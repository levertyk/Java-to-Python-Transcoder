# FinalProject
**MSCS 271 - Formal Languages and Finite Automata**

 Chris Allender  
 Keenan Leverty  
 Peter Matern

## Instructions
Simply run the .java file and input your java code to get the python equivalent.

## Accepted functions:
- Variables:
    - Int
    - Double
    - String
    - Character
    - Array
    - Boolean
- Arithmetic operations
- Conditionals
- Loops
- Scanner input
- System output

## Example input and output:
Java Input:
```java
import java.util.Scanner;
public class Test1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int bigNumbers = 0;

        System.out.println("Hello world!");

        System.out.println("Please enter a number:");
        int input = sc.nextInt();

        String output = "\n\n";

        for(int i = 0; i < input; i++) {
            output += i + " x 4 = " + i*4 + "\n";

            if(i > 5) {
                bigNumbers += 1;
            }
        }

        System.out.println(output);
        System.out.println("There were " + bigNumbers + " big numbers!");

        sc.close();
    }
}
```

Python Output:
```py

bigNumbers=0
print("Hello world!")
print("Please enter a number:")
input=input()
output="\n\n"
i=0
while i<input :
	output+=i+" x 4 = "+i*4+"\n"
	if i>5 :
		bigNumbers+=1
	i += 1
print(output)
print("There were "+bigNumbers+" big numbers!")

```
