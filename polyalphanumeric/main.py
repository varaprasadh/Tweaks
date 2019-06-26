def main():
    message=input("enter message : ")
    key=input("enter key : ")
    cipher=encrypt(message,key)
    print("cipher text is :"+cipher)
    #decryption
    message=decrypt(cipher,key)
    print("decrypted message: "+message)
def encrypt(message,key):
    keyIdx=0
    cipher=''
    for char in message:
        keychar=key[keyIdx:keyIdx+2]
        cipherKey=abs(ord(char)+int(keychar))%126
        cipherKey=cipherKey if cipherKey>=32 else cipherKey+32
        cipher+=chr(cipherKey)
        keyIdx=(keyIdx+2)%len(key)
    return cipher

def decrypt(cipher,key):
    message=''
    keyIdx=0;
    for char in cipher:
        keychar=key[keyIdx:keyIdx+2]
        msgKey=ord(char)-int(keychar) if ord(char)-int(keychar)>=32 else ord(char)-int(keychar)-32
        msgKey=(126+msgKey)%126
        message+=chr(msgKey)
        keyIdx=(keyIdx+2)%len(key)
    return message

main()
