# MonteCarloOptionPricing

This repository provides implementations of option pricing using Monte Carlo simulation in three different programming languages: C++, Python, and Java.

## Description

Option pricing is an important concept in financial mathematics, and Monte Carlo simulation is a widely used technique for pricing options. This repository demonstrates the Monte Carlo method for pricing European vanilla call and put options.

The following programming languages are used for the implementation:

- C++
- Python
- Java

Each language-specific implementation consists of classes and functions organized in an object-oriented format, allowing for easy reuse and extension.

## Files

The repository contains the following files:

- `MonteCarloOptionPricing.cpp`: C++ implementation of option pricing using Monte Carlo simulation.
- `MonteCarloOptionPricing.py`: Python implementation of option pricing using Monte Carlo simulation.
- `MonteCarloOptionPricing.java`: Java implementation of option pricing using Monte Carlo simulation.

## Usage

Each file can be compiled and executed independently in its respective language.

### C++

To compile and run the C++ code, use the following commands:

```bash
g++ MonteCarloOptionPricing.cpp -o MonteCarloOptionPricing && ./MonteCarloOptionPricing
```


### Python

To run the Python code, use the following command:

```bash
python MonteCarloOptionPricing.py
```


### Java

To compile and run the Java code, use the following commands:

```bash
javac MonteCarloOptionPricing.java && java MonteCarloOptionPricing
```


## Inputs

The inputs for option pricing are set within the main functions of each implementation. The common input parameters include:

- `numSims`: Number of simulated asset paths.
- `S`: Option price.
- `K`: Strike price.
- `r`: Risk-free rate.
- `v`: Volatility of the underlying.
- `T`: Time to expiry.

You can modify these input parameters according to your requirements and run the code to obtain the option prices.

## Outputs

The program calculates and displays the prices of European vanilla call and put options using Monte Carlo simulation. The output includes the following information:

- Number of simulated asset paths.
- Option price inputs (underlying, strike, risk-free rate, volatility, and time to expiry).
- Call price.
- Put price.

## License

This project is licensed under the MIT License.

## Contributions

Contributions to this repository are welcome. If you find any issues or want to add enhancements, feel free to open a pull request.

## Disclaimer

The code provided in this repository is for educational and demonstration purposes only. It should not be used for actual trading or financial decisions. Use it at your own risk.

Please consult with a qualified financial advisor or professional before making any investment or trading decisions.

## Acknowledgments

The implementation in this repository is based on the concepts of option pricing and Monte Carlo simulation. Special thanks to Michael Halle-Moore for his book "C++ For Quantitative Finance" [1], and the blog article on European vanilla option pricing with C++ via Monte Carlo methods from QuantStart [2] that provided valuable insights.


## References

[1] Michael Halle-Moore, "C++ For Quantitative Finance."

[2] QuantStart, "[European vanilla option pricing with C++ via Monte Carlo methods.](https://www.quantstart.com/articles/European-vanilla-option-pricing-with-C-via-Monte-Carlo-methods/)
" 
---

