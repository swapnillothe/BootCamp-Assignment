package probability;

import java.util.Objects;

class Probability {
    private static final int LOWER_BOUND = 0;
    private static final int UPPER_BOUND = 1;
    private final Double probability;

    Probability(Double probability) throws InvalidProbabilityException {
        this.validateProbability(probability);
        this.probability = probability;
    }

    private void validateProbability(Double probability) throws InvalidProbabilityException {
        if (probability > UPPER_BOUND || probability < LOWER_BOUND) {
            throw new InvalidProbabilityException("Invalid Probability");
        }
    }

    Probability not() throws InvalidProbabilityException {
        Double probability = UPPER_BOUND - this.probability;
        return new Probability(probability);
    }

    @Override
    public boolean equals(Object otherProbability) {
        if (this == otherProbability) return true;
        if (!(otherProbability instanceof Probability)) return false;
        Probability that = (Probability) otherProbability;
        return Objects.equals(probability, that.probability);
    }

    Probability and(Probability otherProbability) throws InvalidProbabilityException {
        Double combinedProbability = this.probability * otherProbability.probability;
        return new Probability(combinedProbability);
    }


    Probability or(Probability probability2) throws InvalidProbabilityException {
        Double value = UPPER_BOUND - this.and(probability2).probability;
        return new Probability(value);
    }
}
