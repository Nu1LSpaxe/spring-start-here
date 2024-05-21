package springboot.model;

public class Country {

    private String name;
    private Integer population;

    public String getName() {
        return name;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public static Country of(
            String name,
            Integer population
    ) {
        Country country = new Country();
        country.setName(name);
        country.setPopulation(population);
        return country;
    }
}
