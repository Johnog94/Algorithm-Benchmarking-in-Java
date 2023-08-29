package ie.atu.sw;

public class Runner {

    public static void main(String[] args) throws Exception { // Main method for application
        Benchmarking bm = new Benchmarking(); // call new benchmarking class as bm
        bm.runTests(); // new bm runs tests on each algorithm
    }
}
