
public class MyList {

    Node head, tail;

    MyList() {
        head = tail = null;
    }

    boolean isEmpty() {
        return (head == null);
    }

    void clear() {
        head = tail = null;
    }

    // (1) 
    void addLast(Person x) {
        Node q = new Node(x);
        if (isEmpty()) {
            head = tail = q;
            return;
        }
        tail.next = q;
        tail = q;
    }

    void visit(Node p) {
        if (p != null) {
            System.out.print(p.info);
        }
    }

    void traverse() {
        Node p = head;
        while (p != null) {
            visit(p);
            p = p.next;
        }
        System.out.println();
    }

    void addMany(String[] a, int[] b) {
        int n, i;
        n = a.length;
        for (i = 0; i < n; i++) {
            addLast(new Person(a[i], b[i]));
        }
    }

    // (2)
    Node searchByName(String xName) {
        Node p = head;
        while (p != null) {
            if (p.info.name.equals(xName)) {
                return (p);
            }
            p = p.next;
        }
        return (null);
    }

    // (3)
    void addFirst(Person x) {
        Node newNode = new Node(x);
        if (isEmpty()) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    // (4)
    void insertAfter(Node q, Person x) {
        if (tail == q) {
            addLast(x);
            return;
        }
        Node newNode = new Node(x);
        newNode.next = q.next;
        q.next = newNode;
    }

    // (5)
    void insertBefore(Node q, Person x) {
        if (head == q) {
            addFirst(x);
            return;
        }
        Node newNode = new Node(x);
        Node p = head;
        for (Node n = head; n != q; n = n.next) {
            p = n;
        }
        newNode.next = q;
        p.next = newNode;
    }

    // (6)
    void remove(Node q) {
        if (isEmpty()) {
            return;
        }
        if (head == q) {
            head = head.next;
            return;
        }

        if (tail == q) {
            q.next = null;
            tail = q;
            return;
        }
        Node p = head;
        for (Node n = head; n != q; n = n.next) {
            p = n;
        }
        p.next = p.next.next;
    }

    // (7)
    void remove(String xName) {
        if (isEmpty()) {
            return;
        }
        Node q = searchByName(xName);
        remove(q);
    }

    // (8)
    void remove(int xAge) {
        if (isEmpty()) {
            return;
        }
        Node q = head;
        while (q.info.age != xAge) {
            q = q.next;
        }
        remove(q);
    }

    // (9)
    void removeAll(int xAge) {
        if (isEmpty()) {
            return;
        }
        Node q = head;
        while (q != null) {
            if (q.info.age == xAge) {
                remove(q);
            }
            q = q.next;
        }
    }

    // (10)
    Node pos(int k) {
        if (isEmpty()) {
            return null;
        }
        if (k < 0 || k > size() - 1) {
            return null;
        }
        int count = 0;
        Node q = head;
        while (count != k) {
            count++;
            q = q.next;
        }
        return q;
    }

    // (11)
    void removePos(int k) {
        Node q = pos(k);
        remove(q);
    }

    // (12)
    void sortByName() {
        Node current = head, index = null;
        Person temp;
        if (isEmpty()) {
            return;
        }
        while (current != null) {
            index = current.next;
            
            while (index != null) {
                if (current.info.name.compareToIgnoreCase(index.info.name) > 0) {
                    temp = current.info;
                    current.info = index.info;
                    index.info = temp;
                }
                index = index.next;
            }
            
            current = current.next;
        }
    }

    // (13)
    void sortByAge() {
        Node current = head, index = null;
        Person temp;
        if (isEmpty()) {
            return;
        }
        while (current != null) {
            index = current.next;
            
            while (index != null) {
                if (current.info.age > index.info.age) {
                    temp = current.info;
                    current.info = index.info;
                    index.info = temp;
                }
                index = index.next;
            }
            
            current = current.next;
        }
    }

    // (14)
    int size() {
        int count = 0;
        Node q = head;
        while (q != null) {
            count++;
            q = q.next;
        }
        return count;
    }

    // (15)
    Person[] toArray() {
        Person[] arr = new Person[size()];
        int count = 0;
        for (Node q = head; q != null; q = q.next) {
            arr[count++] = q.info;
        }
        return arr;

    }

    // (16)
    void reverse() {
        Node prev = null;
        Node cur = head;
        Node next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        head = prev;
    }

    // (17) 
    Node findMaxAge() {
        Node q = head;
        Node minAge = head;
        while (q != null) {
            if (minAge.info.age < q.info.age) {
                minAge.info.age = q.info.age;
                minAge = q;
            }
            q = q.next;
        }
        return minAge;
    }

    // (18) 
    Node findMinAge() {
        Node q = head;
        Node minAge = head;
        while (q != null) {
            if (minAge.info.age > q.info.age) {
                minAge.info.age = q.info.age;
                minAge = q;
            }
            q = q.next;
        }
        return minAge;
    }

    // (19) 
    void setData(Node p, Person x) {
        p.info = x;
    }

    // (20) 
    void sortByAge(int k, int h) // Sort from position k to position h (the position of the first element is 0)
    {
        Node start = pos(k);
        Node end = pos(h).next;
        
        Node current = start;
        Person temp;
        while (current != end) {
            Node index = current.next;
            
            while (index != end) {
                if (current.info.age > index.info.age) {
                    temp = current.info;
                    current.info = index.info;
                    index.info = temp;
                }
                index = index.next;
            }
            
            current = current.next;
        }
    }

    // (21) 
    void reverse(int k, int h) // reverse from position k to position h (the position of the first element is 0) 
    {
        Node start;
        if (k == 0) {
            start = new Node(null, head);
        } else {
            start = pos(k-1);
        }
        Node end = pos(h);
        
        Node left = start.next;
        Node right = end.next;
        
        Node prev = null;
        Node cur = start;
        Node next = null;
        while (cur != end) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        
        cur.next = prev;
        start.next = cur;
        left.next = right;
        
        if (k == 0) {
            head = cur;
        }
    }
}
