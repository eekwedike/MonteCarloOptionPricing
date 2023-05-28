#include <iostream>
#include <cmath>
#include <random>
#include <algorithm>

class MonteCarloOptionPricing {
private:
    int numSims;
    double S;
    double K;
    double r;
    double v;
    double T;

    double gaussianBoxMuller() {
        double x, y, euclidSq;

        do {
            x = 2.0 * rand() / static_cast<double>(RAND_MAX) - 1;
            y = 2.0 * rand() / static_cast<double>(RAND_MAX) - 1;
            euclidSq = x * x + y * y;
        } while (euclidSq >= 1.0);

        return x * sqrt(-2 * log(euclidSq) / euclidSq);
    }

    double monteCarloPrice(bool isCall) {
        double SAdjust = S * exp(T * (r - 0.5 * v * v));
        double SCur, payoffSum = 0.0;

        for (int i = 0; i < numSims; i++) {
            double gaussBm = gaussianBoxMuller();
            SCur = SAdjust * exp(sqrt(v * v * T) * gaussBm);

            if (isCall)
                payoffSum += std::max(SCur - K, 0.0);
            else
                payoffSum += std::max(K - SCur, 0.0);
        }

        return (payoffSum / static_cast<double>(numSims)) * exp(-r * T);
    }

public:
    MonteCarloOptionPricing(int numSims, double S, double K, double r, double v, double T)
        : numSims(numSims), S(S), K(K), r(r), v(v), T(T) {}

    void calculateOptionPrices() {
        double callPrice = monteCarloPrice(true);
        double putPrice = monteCarloPrice(false);

        displayResults(callPrice, putPrice);
    }

    void displayResults(double callPrice, double putPrice) {
        std::cout << "Number of Paths: " << numSims << std::endl;
        std::cout << "Underlying: " << S << std::endl;
        std::cout << "Strike: " << K << std::endl;
        std::cout << "Risk-Free Rate: " << r << std::endl;
        std::cout << "Volatility: " << v << std::endl;
        std::cout << "Maturity: " << T << std::endl;

        std::cout << "Call Price: " << callPrice << std::endl;
        std::cout << "Put Price: " << putPrice << std::endl;
    }
};

int main() {
    int numSims = 100000;
    double S = 200.0;
    double K = 200.0;
    double r = 0.07;
    double v = 0.3;
    double T = 1.0;

    MonteCarloOptionPricing option(numSims, S, K, r, v, T);
    option.calculateOptionPrices();

    return 0;
}
