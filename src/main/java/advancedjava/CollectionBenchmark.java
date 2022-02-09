package advancedjava;

import java.util.*;

public class CollectionBenchmark {


    public static long test(Collection<Long> collection, AtomicCollectionAction atomicAction, int nbIteration ) {

        long start = System.currentTimeMillis();

        for( int i = 0; i < nbIteration; i++ ) {
            atomicAction.doAction(collection);
        }

        long end = System.currentTimeMillis();

        return end - start;

    }

    static public void doTest(Collection<Long> collection) {

        long time;
        final Random r = new Random(System.currentTimeMillis());
        time=test(collection, c -> c.add(r.nextLong(100_000_000)), 1_000_000 );

        System.out.println("Test de 1 million d'ajouts de valeurs aléatoires comprises entre 0 et 100000000, en fin de collection : " + time + "ms");

        time = test( collection, c -> c.forEach( v -> {}), 10 );
        System.out.println("Test accès séquentiel de la liste (10 parcours du début jusqu’à la fin) : " + time + "ms");

        time = test(collection, c -> { c.contains(r.nextLong(100_000_000)); }, 1_000);
        System.out.println("Test de 1000 recherches de valeurs dans la collection : " + time + "ms");

        time = test(collection, c -> {
            for(Iterator<Long> it = c.iterator(); it.hasNext();) {
                if(it.next()%2 == 0) {
                    it.remove();
                }
            }
        }, 1);
        System.out.println("Test de suppression des nombres pairs (avec un itérateur) : " + time + "ms");

        time = test(collection, c -> c.removeIf(aLong -> aLong%2 == 0), 1);
        System.out.println("Test de suppression des nombres pairs (avec removeIf et un itérateur) : " + time + "ms");

        time = test( collection, c -> c.stream().findAny().get(), 10_000 );
        System.out.println("Test de 10 milles d'accès aléatoires dans la liste : " + time + "ms");

        System.out.println("\n\n");

    }

    public static void main(String[] args) {
        doTest( new ArrayList<>() );
        doTest( new LinkedList<>() );
        doTest( new HashSet<>() );
    }
}
