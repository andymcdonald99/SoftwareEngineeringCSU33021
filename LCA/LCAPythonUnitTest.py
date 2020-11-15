import unittest
import LCAPython
from LCAPython import Node, findLCA


class TestTree(unittest.TestCase):

#         Tree Diagram :  

#                                   1
#                               /       \
#                           2               3
#                       /       \         /     \
#                     4            5     6        7
    def testPath45equals2(self):

        root = Node(1)
        root.l = Node(2)
        root.r = Node(3)
        root.l.l = Node(4)
        root.l.r = Node(5)
        root.r.l = Node(6)
        root.r.r = Node(7)
        expected = 2 
        self.assertEquals(findLCA(root,4, 5), expected)
    
    def testPath67equals3(self):
    
        root = Node(1)
        root.l = Node(2)
        root.r = Node(3)
        root.l.l = Node(4)
        root.l.r = Node(5)
        root.r.l = Node(6)
        root.r.r = Node(7)
        expected = 3 
        self.assertEquals(findLCA(root,6, 7), expected)

    def testPath47equals1(self):
        
        root = Node(1)
        root.l = Node(2)
        root.r = Node(3)
        root.l.l = Node(4)
        root.l.r = Node(5)
        root.r.l = Node(6)
        root.r.r = Node(7)
        expected = 1 
        self.assertEquals(findLCA(root,4, 7), expected)    

if __name__ == "__main__":
    unittest.main()

     
        
