import java.util.Random;

public class MonteCarloOptionPricing {
    private int num_sims;
    private double S;
    private double K;
    private double r;
    private double v;
    private double T;

    public MonteCarloOptionPricing(int num_sims, double S, double K, double r, double v, double T) {
        this.num_sims = num_sims;
        this.S = S;
        this.K = K;
        this.r = r;
        this.v = v;
        this.T = T;
    }

    private double gaussianBoxMuller() {
        double x, y, euclid_sq;
        Random rand = new Random();

        do {
            x = 2.0 * rand.nextDouble() - 1;
            y = 2.0 * rand.nextDouble() - 1;
            euclid_sq = x * x + y * y;
        } while (euclid_sq >= 1.0);

        return x * Math.sqrt(-2 * Math.log(euclid_sq) / euclid_sq);
    }

    private double monteCarloPrice(boolean isCall) {
        double S_adjust = S * Math.exp(T * (r - 0.5 * v * v));
        double S_cur, payoff_sum = 0.0;

        for (int i = 0; i < num_sims; i++) {
            double gauss_bm = gaussianBoxMuller();
            S_cur = S_adjust * Math.exp(Math.sqrt(v * v * T) * gauss_bm);

            if (isCall)
                payoff_sum += Math.max(S_cur - K, 0.0);
            else
                payoff_sum += Math.max(K - S_cur, 0.0);
        }

        return (payoff_sum / num_sims) * Math.exp(-r * T);
    }

    public void calculateOptionPrices() {
        double callPrice = monteCarloPrice(true);
        double putPrice = monteCarloPrice(false);

        displayResults(callPrice, putPrice);
    }

    private void displayResults(double callPrice, double putPrice) {
        System.out.println("Number of Paths: " + num_sims);
        System.out.println("Underlying: " + S);
        System.out.println("Strike: " + K);
        System.out.println("Risk-Free Rate: " + r);
        System.out.println("Volatility: " + v);
        System.out.println("Maturity: " + T);

        System.out.println("Call Price: " + callPrice);
        System.out.println("Put Price: " + putPrice);
    }

    public static void main(String[] args) {
        int num_sims = 1000000;
        double S = 200.0;
        double K = 200.0;
        double r = 0.07;
        double v = 0.3;
        double T = 1.0;

        MonteCarloOptionPricing option = new MonteCarloOptionPricing(num_sims, S, K, r, v, T);
        option.calculateOptionPrices();
    }
}
