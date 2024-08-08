package revise._2024.striver.linkedlist.mediumHardDLL;

public class DesignBrowserHistory {
    static class Node {
        public Node back;
        public String data;
        public Node next;

        public Node(String data) {
            this.data = data;
        }
    }

    static public class Browser {
        Node currPage;

        public Browser(String homePage) {
            this.currPage = new Node(homePage);
        }

        public void visit(String url) {
            Node newNode = new Node(url);
            newNode.back = currPage;
            currPage.next = newNode;

            currPage = newNode;
        }

        public String back(int steps) {
            while (steps-- > 0 && currPage.back != null)
                currPage = currPage.back;

            return currPage.data;
        }

        public String forward(int steps) {
            while (steps-- > 0 && currPage.next != null)
                currPage = currPage.next;

            return currPage.data;
        }
    }

    public static void main(String[] args) {
        Browser browser = new Browser("homepage.com");
        browser.visit("page.com");
//        browser.visit("codingninjas.com");
        System.out.println(browser.back(3));
        System.out.println(browser.forward(3));
    }
}
