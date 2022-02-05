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

package uk.gov.gchq.syntheticdatagenerator.types;

import java.util.Random;

/**
 * @enum Nationality
 * @brief This enum class lists different nationalities
 */
public enum Nationality {
    AFGHAN,
    ALBANIAN,
    ALGERIAN,
    AMERICAN,
    ANDORRAN,
    ANGOLAN,
    ANGUILLAN,
    CITIZEN_OF_ANTIGUA_AND_BARBUDA,
    ARGENTINE,
    ARMENIAN,
    AUSTRALIAN,
    AUSTRIAN,
    AZERBAIJANI,
    BAHAMIAN,
    BAHRAINI,
    BANGLADESHI,
    BARBADIAN,
    BELARUSIAN,
    BELGIAN,
    BELIZEAN,
    BENINESE,
    BERMUDIAN,
    BHUTANESE,
    BOLIVIAN,
    CITIZEN_OF_BOSNIA_AND_HERZEGOVINA,
    BOTSWANAN,
    BRAZILIAN,
    BRITISH,
    BRITISH_VIRGIN_ISLANDER,
    BRUNEIAN,
    BULGARIAN,
    BURKINAN,
    BURMESE,
    BURUNDIAN,
    CAMBODIAN,
    CAMEROONIAN,
    CANADIAN,
    CAPE_VERDEAN,
    CAYMAN_ISLANDER,
    CENTRAL_AFRICAN,
    CHADIAN,
    CHILEAN,
    CHINESE,
    COLOMBIAN,
    COMORAN,
    CONGOLESE,
    COOK_ISLANDER,
    COSTA_RICAN,
    CROATIAN,
    CUBAN,
    CYMRAES,
    CYMRO,
    CYPRIOT,
    CZECH,
    DANISH,
    DJIBOUTIAN,
    DOMINICAN,
    CITIZEN_OF_THE_DOMINICAN_REPUBLIC,
    DUTCH,
    EAST_TIMORESE,
    ECUADOREAN,
    EGYPTIAN,
    EMIRATI,
    ENGLISH,
    EQUATORIAL_GUINEAN,
    ERITREAN,
    ESTONIAN,
    ETHIOPIAN,
    FAROESE,
    FIJIAN,
    FILIPINO,
    FINNISH,
    FRENCH,
    GABONESE,
    GAMBIAN,
    GEORGIAN,
    GERMAN,
    GHANAIAN,
    GIBRALTARIAN,
    GREEK,
    GREENLANDIC,
    GRENADIAN,
    GUAMANIAN,
    GUATEMALAN,
    CITIZEN_OF_GUINEA_BISSAU,
    GUINEAN,
    GUYANESE,
    HAITIAN,
    HONDURAN,
    HONG_KONGER,
    HUNGARIAN,
    ICELANDIC,
    INDIAN,
    INDONESIAN,
    IRANIAN,
    IRAQI,
    IRISH,
    ISRAELI,
    ITALIAN,
    IVORIAN,
    JAMAICAN,
    JAPANESE,
    JORDANIAN,
    KAZAKH,
    KENYAN,
    KITTITIAN,
    CITIZEN_OF_KIRIBATI,
    KOSOVAN,
    KUWAITI,
    KYRGYZ,
    LAO,
    LATVIAN,
    LEBANESE,
    LIBERIAN,
    LIBYAN,
    LIECHTENSTEIN_CITIZEN,
    LITHUANIAN,
    LUXEMBOURGER,
    MACANESE,
    MACEDONIAN,
    MALAGASY,
    MALAWIAN,
    MALAYSIAN,
    MALDIVIAN,
    MALIAN,
    MALTESE,
    MARSHALLESE,
    MARTINIQUAIS,
    MAURITANIAN,
    MAURITIAN,
    MEXICAN,
    MICRONESIAN,
    MOLDOVAN,
    MONEGASQUE,
    MONGOLIAN,
    MONTENEGRIN,
    MONTSERRATIAN,
    MOROCCAN,
    MOSOTHO,
    MOZAMBICAN,
    NAMIBIAN,
    NAURUAN,
    NEPALESE,
    NEW_ZEALANDER,
    NICARAGUAN,
    NIGERIAN,
    NIGERIEN,
    NIUEAN,
    NORTH_KOREAN,
    NORTHERN_IRISH,
    NORWEGIAN,
    OMANI,
    PAKISTANI,
    PALAUAN,
    PALESTINIAN,
    PANAMANIAN,
    PAPUA_NEW_GUINEAN,
    PARAGUAYAN,
    PERUVIAN,
    PITCAIRN_ISLANDER,
    POLISH,
    PORTUGUESE,
    PRYDEINIG,
    PUERTO_RICAN,
    QATARI,
    ROMANIAN,
    RUSSIAN,
    RWANDAN,
    SALVADOREAN,
    SAMMARINESE,
    SAMOAN,
    SAO_TOMEAN,
    SAUDI_ARABIAN,
    SCOTTISH,
    SENEGALESE,
    SERBIAN,
    CITIZEN_OF_SEYCHELLES,
    SIERRA_LEONEAN,
    SINGAPOREAN,
    SLOVAK,
    SLOVENIAN,
    SOLOMON_ISLANDER,
    SOMALI,
    SOUTH_AFRICAN,
    SOUTH_KOREAN,
    SOUTH_SUDANESE,
    SPANISH,
    SRI_LANKAN,
    ST_HELENIAN,
    ST_LUCIAN,
    STATELESS,
    SUDANESE,
    SURINAMESE,
    SWAZI,
    SWEDISH,
    SWISS,
    SYRIAN,
    TAIWANESE,
    TAJIK,
    TANZANIAN,
    THAI,
    TOGOLESE,
    TONGAN,
    TRINIDADIAN,
    TRISTANIAN,
    TUNISIAN,
    TURKISH,
    TURKMEN,
    TURKS_AND_CAICOS_ISLANDER,
    TUVALUAN,
    UGANDAN,
    UKRAINIAN,
    URUGUAYAN,
    UZBEK,
    VATICAN_CITIZEN,
    CITIZEN_OF_VANUATU,
    VENEZUELAN,
    VIETNAMESE,
    VINCENTIAN,
    WALLISIAN,
    WELSH,
    YEMENI,
    ZAMBIAN,
    ZIMBABWEAN;

    /**
     * @brief This method generates a nationality
     * @param random random value
     * @return nationality
     */
    public static Nationality generate(final Random random) {
        return Nationality.values()[random.nextInt(Nationality.values().length)];
    }
}