class Node:
    def __init__(self, data):
        self.data = data
        self.next = None
    
class LinkedList:
    def __init__(self):
        self.head = None
        
    def printlist(self):
        temp = self.head
        while(temp):
            print(temp.data)
            temp = temp.next
    
    def addNode(self, data):
        if(self.head == None):
            self.head = Node(data)
            return
        temp = self.head
        while(temp.next):
            temp = temp.next
            
        temp.next = Node(data)
          
if __name__=='__main__':
    llist = LinkedList()
    llist.addNode(1)
    llist.addNode(2)
    llist.addNode(3)
    llist.addNode(4)
    llist.addNode(5)
    
    llist.printlist()