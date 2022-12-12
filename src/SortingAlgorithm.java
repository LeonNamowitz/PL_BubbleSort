public interface SortingAlgorithm {
   
    long sort(int[] elements);

  
    default String getName() {
      return this.getClass().getSimpleName();
    }
}
