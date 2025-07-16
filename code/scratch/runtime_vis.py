import matplotlib.pyplot as plt
import math

# Define the range of n values
n = list(range(1, 11))

# Define the runtime functions
runtime_classes = {
    'O(1)': [1]*len(n),
    'O(log n)': [math.log(x, 2) for x in n],
    'O(n)': [x for x in n],
    'O(n log n)': [x * math.log(x, 2) for x in n],
    'O(n²)': [x**2 for x in n],
    'O(n³)': [x**3 for x in n],
    'O(2ⁿ)': [2**x for x in n],
    'O(n!)': [math.factorial(x) for x in n],
}

# Create the plot
plt.figure()
for label, values in runtime_classes.items():
    plt.plot(n, values, label=label)

# Use a log scale on the y-axis to show wide-ranging growth
plt.yscale('log')
plt.xlabel('n')
plt.ylabel('f(n) (log scale)')
plt.title('Common Asymptotic Complexity Classes')
plt.legend()
plt.show()
