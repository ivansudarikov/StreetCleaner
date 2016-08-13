package io.angelhack.rest.pojo;

public class ScenarioVox {
    private String scenario_name;
    private String scenario_id;

    public String getScenario_name() {
        return scenario_name;
    }

    public void setScenario_name(String scenario_name) {
        this.scenario_name = scenario_name;
    }

    public String getScenario_id() {
        return scenario_id;
    }

    public void setScenario_id(String scenario_id) {
        this.scenario_id = scenario_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ScenarioVox that = (ScenarioVox) o;

        if (scenario_name != null ? !scenario_name.equals(that.scenario_name) : that.scenario_name != null)
            return false;
        return !(scenario_id != null ? !scenario_id.equals(that.scenario_id) : that.scenario_id != null);

    }

    @Override
    public int hashCode() {
        int result = scenario_name != null ? scenario_name.hashCode() : 0;
        result = 31 * result + (scenario_id != null ? scenario_id.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ScenarioVox{" +
                "scenario_name='" + scenario_name + '\'' +
                ", scenario_id='" + scenario_id + '\'' +
                '}';
    }

}
