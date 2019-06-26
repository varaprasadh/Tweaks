import string

def main():
    message=input("enter message : ")
    key=input("enter key")
    cipher=encrypt(message,key)
def encrypt(message,key):
    cipher=''
    
    return cipher
def decrypt(message,key):
    message=''

    return message

def genrateMat(key):
    keySet=set(key)
    keytext=''.join(str(char) for char in list(keySet)))
    alphabetSet=set(string.ascii_uppercase);
    matText=''.join(str(char) for char in list(alphabetSet.difference(keySet)))
    matrixText=keySet+matText
    matrix=[]
    return matrixText

main()
