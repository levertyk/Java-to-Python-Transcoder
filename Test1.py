
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
