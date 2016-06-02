package com.grayraven.ectest4.pojos;

    public class State
    {
        private String Abv;

        private String Total_Votes;

        private String Include;

        private String Slate0_Votes;

        public State() {};

        public String getAbv ()
        {
            return Abv;
        }

        public void setAbv (String Abv)
        {
            this.Abv = Abv;
        }

        public String getTotal_Votes ()
        {
            return Total_Votes;
        }

        public void setTotal_Votes (String Total_Votes)
        {
            this.Total_Votes = Total_Votes;
        }

        public String getInclude ()
        {
            return Include;
        }

        public void setInclude (String Include)
        {
            this.Include = Include;
        }

        public String getSlate0_Votes ()
        {
            return Slate0_Votes;
        }

        public void setSlate0_Votes (String Slate0_Votes)
        {
            this.Slate0_Votes = Slate0_Votes;
        }

        @Override
        public String toString()
        {
            return "ClassPojo [Abv = "+Abv+", Total_Votes = "+Total_Votes+", Include = "+Include+", Slate0_Votes = "+Slate0_Votes+"]";
        }
    }
