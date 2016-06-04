package com.grayraven.ectest4.pojos;

/**
 * generated at http://www.jsonschema2pojo.org/
 */
public class VoteDistribution {

        private String year;
        private int aL;
        private int aK;
        private int tX;

        /**
         * No args constructor for use in serialization
         *
         */
        public VoteDistribution() {
        }

        /**
         *
         * @param aK
         * @param aL
         * @param year
         * @param tX
         */
        public VoteDistribution(String year, int aL, int aK, int tX) {
            this.year = year;
            this.aL = aL;
            this.aK = aK;
            this.tX = tX;
        }

        /**
         *
         * @return
         * The year
         */
        public String getYear() {
            return year;
        }

        /**
         *
         * @param year
         * The Year
         */
        public void setYear(String year) {
            this.year = year;
        }

        /**
         *
         * @return
         * The aL
         */
        public int getAL() {
            return aL;
        }

        /**
         *
         * @param aL
         * The AL
         */
        public void setAL(int aL) {
            this.aL = aL;
        }

        /**
         *
         * @return
         * The aK
         */
        public int getAK() {
            return aK;
        }

        /**
         *
         * @param aK
         * The AK
         */
        public void setAK(int aK) {
            this.aK = aK;
        }

        /**
         *
         * @return
         * The tX
         */
        public int getTX() {
            return tX;
        }

        /**
         *
         * @param tX
         * The TX
         */
        public void setTX(int tX) {
            this.tX = tX;
        }

    }
