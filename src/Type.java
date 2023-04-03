
    public enum Type {
        PERSONAL("Личные"),
        PROFESSIONAL("Рабочие");
        private String type;

        Type(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }


        @Override
        public String toString() {
            return
                    type;
        }

        public void checkType(Type type) throws IncorrectArgumentTaskException {
            if (type != Type.PROFESSIONAL) {
                throw new IncorrectArgumentTaskException("Выберите из списка");
            }
        }
    }

