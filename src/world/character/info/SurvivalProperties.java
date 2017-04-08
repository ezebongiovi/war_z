package world.character.info;



public final class SurvivalProperties {
        int health;
        int stamina;
        int hungry;
        int temperature;
        int infection;
        int hydratation;

        private SurvivalProperties(final Builder builder) {
            this.health = builder.health;
            this.stamina = builder.stamina;
            this.hungry = builder.hungry;
            this.temperature = builder.temperature;
            this.infection = builder.infection;
            this.hydratation = builder.hydratation;
        }

        public int getHealth() {
            return health;
        }

        public int getStamina() {
            return stamina;
        }

        public int getHungry() {
            return hungry;
        }

        public int getTemperature() {
            return temperature;
        }

        public int getInfection() {
            return infection;
        }

        public int getHydratation() {
            return hydratation;
        }

        public static final class Builder {
            private static final int BASIC_HEALTH = 100;
            private static final int BASIC_STAMINA = 100;
            private static final int BASIC_HUNGRY = 100;
            private static final int BASIC_TEMPERATURE = 37;
            private static final int BASIC_INFECTION = 0;
            private static final int BASIC_HYDRATATION = 100;


            private int health = BASIC_HEALTH;
            private int stamina = BASIC_STAMINA;
            private int hungry = BASIC_HUNGRY;
            private int temperature = BASIC_TEMPERATURE;
            private int infection = BASIC_INFECTION;
            private int hydratation = BASIC_HYDRATATION;

            public Builder() {

            }

            public Builder withHealth(final int health) {
                this.health = health;
                return this;
            }

            public Builder withStamina(final int stamina) {
                this.stamina = stamina;
                return this;
            }

            public Builder withHungry(final int hungry) {
                this.hungry = hungry;
                return this;
            }

            public Builder withTemperature(final int temperature) {
                this.temperature = temperature;
                return this;
            }

            public Builder withInfection(final int infection) {
                this.infection = infection;
                return this;
            }

            public Builder withHydratation(final int hydratation) {
                this.hydratation = hydratation;
                return this;
            }

            public SurvivalProperties build() {
                return new SurvivalProperties(this);
            }
        }
    }