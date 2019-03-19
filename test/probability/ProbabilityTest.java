package probability;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProbabilityTest {

    @Test
    void ProbabilityShouldThrowExceptionWhenProbabilityIsGreaterThanOne() {
        assertThrows(InvalidProbabilityException.class, () -> new Probability(2.0D));
    }

    @Test
    void ProbabilityShouldThrowExceptionWhenProbabilityIsLessThanZero() {
        assertThrows(InvalidProbabilityException.class, () -> new Probability(-1.0D));
    }


    @Test
    void ProbabilityShouldCreateAnInstanceWhenProbabilityIsLessThanZero() {
        assertDoesNotThrow(() -> new Probability(1.0D));
    }

    @Test
    void shouldGiveImprobabilityOfGivenProbability() throws InvalidProbabilityException {
        Probability probability = new Probability(0.5D);
        Probability expected = new Probability(0.5D);
        assertEquals(expected, probability.not());
    }

    @Test
    void shouldGiveProbabilityOfGettingTailsOnFlippingTwoCoins() throws InvalidProbabilityException {
        Probability probability1 = new Probability(0.6D);
        Probability probability2 = new Probability(0.4D);
        Probability expected = new Probability(0.24D);
        assertEquals(expected, probability1.and(probability2));
    }

    @Test
    void shouldGiveProbabilityOfGettingAtLeastOneTailOnFlippingTwoCoins() throws InvalidProbabilityException {
        Probability probability1 = new Probability(0.6D);
        Probability probability2 = new Probability(0.4D);
        Probability expected = new Probability(0.76D);
        assertEquals(expected, probability1.or(probability2));
    }
}