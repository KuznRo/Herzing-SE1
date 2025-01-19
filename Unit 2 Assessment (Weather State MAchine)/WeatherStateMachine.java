import java.util.Random;

abstract class Weather {

    public enum WeatherState {
        clear, cloudy, raining, severe
    }

    public enum EventState {
        getting_warmer, getting_colder, humindity_increasing, wind_increasing
    }

    public abstract void startingState();

    public abstract WeatherState nextState(WeatherState currentState, int randomNumber);
}

class Clear extends Weather {
    @Override
    public void startingState() {
        System.out.println("The weather is clear.");
    }

    @Override
    public WeatherState nextState(WeatherState currentState, int randomNumber) {
        switch (randomNumber) {
            case 0:
                return currentState;
            case 2:
                return WeatherState.cloudy;
            default:
                return currentState;
        }
    }
}

class Cloudy extends Weather {
    @Override
    public void startingState() {
        System.out.println("The weather is cloudy.");
    }

    @Override
    public WeatherState nextState(WeatherState currentState, int randomNumber) {
        switch (randomNumber) {
            case 0:
                return WeatherState.clear;
            case 2:
                return WeatherState.raining;
            default:
                return currentState;
        }
    }
}

class Raining extends Weather {
    @Override
    public void startingState() {
        System.out.println("The weather is rainy.");
    }

    @Override
    public WeatherState nextState(WeatherState currentState, int randomNumber) {
        switch (randomNumber) {
            case 0:
                return WeatherState.cloudy;
            case 2:
                return WeatherState.severe;
            default:
                return currentState;
        }
    }
}

class Severe extends Weather {
    @Override
    public void startingState() {
        System.out.println("The weather is severe.");
    }

    @Override
    public WeatherState nextState(WeatherState currentState, int randomNumber) {
        switch (randomNumber) {
            case 0:
                return WeatherState.raining;
            case 2:
                return WeatherState.severe;
            default:
                return currentState;
        }
    }
}

public class WeatherStateMachine {

    public static void main(String[] args) {
        Weather.WeatherState currentState = Weather.WeatherState.clear;
        Weather currentWeather = new Clear();
        Random random = new Random();

        for (int day = 1; day <= 7; day++) {
            System.out.println("Day " + day + ":");
            currentWeather.startingState();

            for (int event = 1; event <= 5; event++) {
                int randomNumber = random.nextInt(3);
                currentState = currentWeather.nextState(currentState, randomNumber);

                Weather.EventState currentEvent;
                switch (currentState) {
                    case clear:
                        currentEvent = Weather.EventState.getting_warmer;
                        System.out.println("It is getting warmer");
                        currentWeather = new Clear();
                        System.out.println();
                        break;
                    case cloudy:
                        currentEvent = Weather.EventState.getting_colder;
                        System.out.println("It is getting colder");
                        currentWeather = new Cloudy();
                        System.out.println();
                        break;
                    case raining:
                        currentEvent = Weather.EventState.humindity_increasing;
                        System.out.println("It is getting humid");
                        currentWeather = new Raining();
                        System.out.println();
                        break;
                    case severe:
                        currentEvent = Weather.EventState.wind_increasing;
                        System.out.println("It is getting windy");
                        currentWeather = new Severe();
                        System.out.println();
                        break;
                    default:
                        currentEvent = Weather.EventState.getting_warmer;
                        currentWeather = new Clear();
                }
                System.out.println("New state " + event + " : "+ currentState);
            }
            System.out.println();
            }

            ;
        }
}
