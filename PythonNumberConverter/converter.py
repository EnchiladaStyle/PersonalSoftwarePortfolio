import random

def main():
    number = "placeholder"
    while number == "placeholder":
        choice = input("Welcome to the converter. Would you like to 1: use a random number? or 2: choose your own number? ")
        if choice == "1":
            number = random.randint(1, 5000)
            system = "1"
        elif choice == "2":
            system = input("Is your input in 1: Decimal, 2: Binary, or 3: Hexidecimal? ")
            number = input("What is your number? ")
        else:
            print("incorrect response. Choose between 1 and 2.")
    
    
    print()

    if system == "1":
        
        print(f"your number in decimal is: {number}")
        print(f"your number in binary is: {Dec_to_bin(number)}")
        print(f"your number in Hexadecimal is: {Dec_to_hex(number)}")


    elif system == "2":
        print(f"your number in decimal is: {Bin_to_dec(number)}")
        print(f"your number in binary is: {number}")
        print(f"your number in hexadecimal is: {Dec_to_hex(Bin_to_dec(number))}")

    elif system == "3":
        print(f"your number in decimal is: {Hex_to_dec(number)}")
        print(f"your number in binary is: {Dec_to_bin(Hex_to_dec(number))}")
        print(f"your number in hexadecimal is {number.upper()}")

    else:
        print("invalid base system")
    print()


def Dec_to_bin(number):
    value = ""
    number = int(number)
    
    while number != 0:
        remainder = number % 2
        value += str(remainder)
        number = number//2
    return value[::-1]

    
        


def Dec_to_hex(number):
    number = int(number)
    answer_str = ""
    
    while number >= 1:

        rem = number%16
        number = int(number/16)

        if rem < 10:
            answer_str += str(rem)
        elif rem == 10:
            answer_str += "A"
        elif rem == 11:
            answer_str += "B"
        elif rem == 12:
            answer_str += "C"
        elif rem == 13:
            answer_str += "D"
        elif rem == 14:
            answer_str += "E"
        elif rem == 15:
            answer_str += "F"

    return answer_str[::-1]



def Bin_to_dec(number):
    
    number = str(number)
    dec_num = 0
    power = 0

    for digit in number[::-1]:
        if digit == "1":
            dec_num += 2**power
        power += 1
    return str(dec_num)


def Hex_to_dec(number):
    
    power = 0
    dec_num = 0
    
    for digit in number[::-1]:
        try:
            digit = digit.upper()
            if digit == "A":
                digit = 10
            elif digit == "B":
                digit = 11
            elif digit == "C":
                digit = 12
            elif digit == "D":
                digit = 13
            elif digit == "E":
                digit = 14
            elif digit == "F":
                digit = 15
            else:
                digit = int(digit)
        except: digit = int(digit)

        dec_num += digit*(16**power)
        power += 1
    
    return str(dec_num)


if __name__ == "__main__":
    main()
