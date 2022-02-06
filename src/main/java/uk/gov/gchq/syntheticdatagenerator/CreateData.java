/*
 * Copyright 2018-2021 Crown Copyright
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.gchq.syntheticdatagenerator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;

/**
 * @class Create Data
 * @brief This class generates new data
 *
 */
public final class CreateData {
    private static final Logger LOGGER = LoggerFactory.getLogger(CreateData.class);
    // Varargs indices
    private static final int MINIMUM_ARGS = 5;
    private static final int OUT_PATH_ARG = 0;
    private static final int NUM_EMPLOYEES_ARG = 1;
    private static final int NUM_FILES_ARG = 2;
    private static final int NUM_THREADS_ARG = 3;
    private static final int IS_JSON_OUT = 4;
    private static final int OCUPATION = 5;

    private CreateData() {
    }

    /**
     * @brief This method is able to generate new data based on the number of arguments as input
     * @param args arguments given as input
     */
    public static void main(final String... args) {
        if (args.length < MINIMUM_ARGS) {
            LOGGER.warn("This method needs at least three arguments. The directory path to save the files in, the number of employee's to generate and the number of files to split those employees between. An optional 4th argument is the number of threads to use which will default to 1.");
        } else {
            String outputFilePath = args[OUT_PATH_ARG];
            // Required minimal arguments
            long numberOfEmployees = Long.parseLong(args[NUM_EMPLOYEES_ARG]);
            int numberOfFiles = Integer.parseInt(args[NUM_FILES_ARG]);
            // Default values
            int numberOfThreads = numberOfFiles;
            // Optional additional arguments overriding default values
            String job = null;
            if (args.length > MINIMUM_ARGS) {
                numberOfThreads = Integer.parseInt(args[NUM_THREADS_ARG]);
                //1 para ejecucion sin csv y 0 para ejecucion modo csv
                job = args[OCUPATION];
            }
            long startTime = System.currentTimeMillis();
            ExecutorService executors = Executors.newFixedThreadPool(numberOfThreads, createDaemonThreadFactory());
            CreateDataFile[] tasks = new CreateDataFile[numberOfFiles];
            long employeesPerFile = numberOfEmployees / numberOfFiles;
        
            // IS_JSON_OUT = 1 JSON
            // IS_JSON_OUT = 0 
            
            
            for (int i = 0; i < numberOfFiles; i++) {
                if(args[IS_JSON_OUT].equals("1")){
                    tasks[i] = new CreateDataFile(employeesPerFile, i, new File(outputFilePath + "/worker_" + job + i + ".json"), job);
                }
                else{
                    tasks[i] = new CreateDataFile(employeesPerFile, i, new File(outputFilePath + "/worker_" + job + i + ".avro" ), job);
                }
            }
            try {
                List<Future<Boolean>> responses = executors.invokeAll(Arrays.asList(tasks));
                for (Future<Boolean> response : responses) {
                    response.get();
                }
            } catch (final Exception e) {
                LOGGER.error(e.getLocalizedMessage());
                Thread.currentThread().interrupt();
            }
            long endTime = System.currentTimeMillis();
            LOGGER.info("Took {}ms to create {} employees", (endTime - startTime), numberOfEmployees);
        }
    }

    /**
     * Create a {@link ThreadFactory} that creates daemon threads that don't prevent JVM exit.
     *
     * @return a daemon thread factory
     */
    public static ThreadFactory createDaemonThreadFactory() {
        //set up a thread to watch this
        final ThreadFactory defaultFactory = Executors.defaultThreadFactory();
        //ensure thread is daemon
        return runnable -> {
            Thread t = defaultFactory.newThread(runnable);
            t.setDaemon(true);
            return t;
        };
    }
}
