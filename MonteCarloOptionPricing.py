import math
import random

class MonteCarloOptionPricing:
    def __init__(self, numSims, S, K, r, v, T):
        self.numSims = numSims
        self.S = S
        self.K = K
        self.r = r
        self.v = v
        self.T = T

    def gaussianBoxMuller(self):
        while True:
            x = 2.0 * random.random() - 1
            y = 2.0 * random.random() - 1
            euclidSq = x * x + y * y

            if euclidSq < 1.0:
                break

        return x * math.sqrt(-2 * math.log(euclidSq) / euclidSq)

    def monteCarloPrice(self, isCall):
        SAdjust = self.S * math.exp(self.T * (self.r - 0.5 * self.v * self.v))
        SCur, payoffSum = 0.0, 0.0

        for _ in range(self.numSims):
            gaussBm = self.gaussianBoxMuller()
            SCur = SAdjust * math.exp(math.sqrt(self.v * self.v * self.T) * gaussBm)

            if isCall:
                payoffSum += max(SCur - self.K, 0.0)
            else:
                payoffSum += max(self.K - SCur, 0.0)

        return (payoffSum / float(self.numSims)) * math.exp(-self.r * self.T)

    def calculateOptionPrices(self):
        callPrice = self.monteCarloPrice(True)
        putPrice = self.monteCarloPrice(False)

        self.displayResults(callPrice, putPrice)

    def displayResults(self, callPrice, putPrice):
        print("Number of Paths:", self.numSims)
        print("Underlying:", self.S)
        print("Strike:", self.K)
        print("Risk-Free Rate:", self.r)
        print("Volatility:", self.v)
        print("Maturity:", self.T)
        print("Call Price:", callPrice)
        print("Put Price:", putPrice)

if __name__ == "__main__":
    numSims = 100000
    S = 200.0
    K = 200.0
    r = 0.07
    v = 0.3
    T = 1.0

    option = MonteCarloOptionPricing(numSims, S, K, r, v, T)
    option.calculateOptionPrices()
