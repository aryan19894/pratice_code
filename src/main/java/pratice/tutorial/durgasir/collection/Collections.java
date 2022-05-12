//package pratice.tutorial.durgasir.collection;
//
////  (version 1.8 : 52.0, super bit)
//public class Collections {
//
//  // Field descriptor #26 I
//  private static final int BINARYSEARCH_THRESHOLD = 5000;
//
//  // Field descriptor #26 I
//  private static final int REVERSE_THRESHOLD = 18;
//
//  // Field descriptor #26 I
//  private static final int SHUFFLE_THRESHOLD = 5;
//
//  // Field descriptor #26 I
//  private static final int FILL_THRESHOLD = 25;
//
//  // Field descriptor #26 I
//  private static final int ROTATE_THRESHOLD = 100;
//
//  // Field descriptor #26 I
//  private static final int COPY_THRESHOLD = 10;
//
//  // Field descriptor #26 I
//  private static final int REPLACEALL_THRESHOLD = 11;
//
//  // Field descriptor #26 I
//  private static final int INDEXOFSUBLIST_THRESHOLD = 35;
//
//  // Field descriptor #277 Ljava/util/Random;
//  private static java.util.Random r;
//
//  // Field descriptor #278 Ljava/util/Set;
//  public static final java.util.Set EMPTY_SET;
//
//  // Field descriptor #275 Ljava/util/List;
//  public static final java.util.List EMPTY_LIST;
//
//  // Field descriptor #276 Ljava/util/Map;
//  public static final java.util.Map EMPTY_MAP;
//
//  // Method descriptor #6 ()V
//  // Stack: 1, Locals: 1
//  private Collections();
//    0  aload_0 [this]
//    1  invokespecial java.lang.Object() [534]
//    4  return
//
//
//  // Method descriptor #357 (Ljava/util/List;)V
//  // Signature: <T::Ljava/lang/Comparable<-TT;>;>(Ljava/util/List<TT;>;)V
//  // Stack: 2, Locals: 1
//  public static void sort(java.util.List arg0);
//    0  aload_0 [arg0]
//    1  aconst_null
//    2  invokeinterface java.util.List.sort(java.util.Comparator) : void [621] [nargs: 2]
//    7  return
//
//
//  // Method descriptor #402 (Ljava/util/List;Ljava/util/Comparator;)V
//  // Signature: <T:Ljava/lang/Object;>(Ljava/util/List<TT;>;Ljava/util/Comparator<-TT;>;)V
//  // Stack: 2, Locals: 2
//  public static void sort(java.util.List arg0, java.util.Comparator arg1);
//    0  aload_0 [arg0]
//    1  aload_1 [arg1]
//    2  invokeinterface java.util.List.sort(java.util.Comparator) : void [621] [nargs: 2]
//    7  return
//
//
//  // Method descriptor #392 (Ljava/util/List;Ljava/lang/Object;)I
//  // Signature: <T:Ljava/lang/Object;>(Ljava/util/List<+Ljava/lang/Comparable<-TT;>;>;TT;)I
//  // Stack: 2, Locals: 2
//  public static int binarySearch(java.util.List arg0, java.lang.Object arg1);
//     0  aload_0 [arg0]
//     1  instanceof java.util.RandomAccess [267]
//     4  ifne 19
//     7  aload_0 [arg0]
//     8  invokeinterface java.util.List.size() : int [618] [nargs: 1]
//    13  sipush 5000
//    16  if_icmpge 25
//    19  aload_0 [arg0]
//    20  aload_1 [arg1]
//    21  invokestatic java.util.Collections.indexedBinarySearch(java.util.List, java.lang.Object) : int [553]
//    24  ireturn
//    25  aload_0 [arg0]
//    26  aload_1 [arg1]
//    27  invokestatic java.util.Collections.iteratorBinarySearch(java.util.List, java.lang.Object) : int [554]
//    30  ireturn
//    Stack map table: number of frames 2
//        [pc: 19, same]
//        [pc: 25, same]
//
//  // Method descriptor #392 (Ljava/util/List;Ljava/lang/Object;)I
//  // Signature: <T:Ljava/lang/Object;>(Ljava/util/List<+Ljava/lang/Comparable<-TT;>;>;TT;)I
//  // Stack: 2, Locals: 7
//  private static int indexedBinarySearch(java.util.List arg0, java.lang.Object arg1);
//     0  iconst_0
//     1  istore_2
//     2  aload_0 [arg0]
//     3  invokeinterface java.util.List.size() : int [618] [nargs: 1]
//     8  iconst_1
//     9  isub
//    10  istore_3
//    11  iload_2
//    12  iload_3
//    13  if_icmpgt 78
//    16  iload_2
//    17  iload_3
//    18  iadd
//    19  iconst_1
//    20  iushr
//    21  istore 4
//    23  aload_0 [arg0]
//    24  iload 4
//    26  invokeinterface java.util.List.get(int) : java.lang.Object [620] [nargs: 2]
//    31  checkcast java.lang.Comparable [206]
//    34  astore 5
//    36  aload 5
//    38  aload_1 [arg1]
//    39  invokeinterface java.lang.Comparable.compareTo(java.lang.Object) : int [608] [nargs: 2]
//    44  istore 6
//    46  iload 6
//    48  ifge 59
//    51  iload 4
//    53  iconst_1
//    54  iadd
//    55  istore_2
//    56  goto 75
//    59  iload 6
//    61  ifle 72
//    64  iload 4
//    66  iconst_1
//    67  isub
//    68  istore_3
//    69  goto 75
//    72  iload 4
//    74  ireturn
//    75  goto 11
//    78  iload_2
//    79  iconst_1
//    80  iadd
//    81  ineg
//    82  ireturn
//    Stack map table: number of frames 5
//        [pc: 11, append: {int, int}]
//        [pc: 59, append: {int, java.lang.Comparable, int}]
//        [pc: 72, same]
//        [pc: 75, chop 3 local(s)]
//        [pc: 78, same]
//
//  // Method descriptor #392 (Ljava/util/List;Ljava/lang/Object;)I
//  // Signature: <T:Ljava/lang/Object;>(Ljava/util/List<+Ljava/lang/Comparable<-TT;>;>;TT;)I
//  // Stack: 2, Locals: 8
//  private static int iteratorBinarySearch(java.util.List arg0, java.lang.Object arg1);
//     0  iconst_0
//     1  istore_2
//     2  aload_0 [arg0]
//     3  invokeinterface java.util.List.size() : int [618] [nargs: 1]
//     8  iconst_1
//     9  isub
//    10  istore_3
//    11  aload_0 [arg0]
//    12  invokeinterface java.util.List.listIterator() : java.util.ListIterator [623] [nargs: 1]
//    17  astore 4
//    19  iload_2
//    20  iload_3
//    21  if_icmpgt 85
//    24  iload_2
//    25  iload_3
//    26  iadd
//    27  iconst_1
//    28  iushr
//    29  istore 5
//    31  aload 4
//    33  iload 5
//    35  invokestatic java.util.Collections.get(java.util.ListIterator, int) : java.lang.Object [555]
//    38  checkcast java.lang.Comparable [206]
//    41  astore 6
//    43  aload 6
//    45  aload_1 [arg1]
//    46  invokeinterface java.lang.Comparable.compareTo(java.lang.Object) : int [608] [nargs: 2]
//    51  istore 7
//    53  iload 7
//    55  ifge 66
//    58  iload 5
//    60  iconst_1
//    61  iadd
//    62  istore_2
//    63  goto 82
//    66  iload 7
//    68  ifle 79
//    71  iload 5
//    73  iconst_1
//    74  isub
//    75  istore_3
//    76  goto 82
//    79  iload 5
//    81  ireturn
//    82  goto 19
//    85  iload_2
//    86  iconst_1
//    87  iadd
//    88  ineg
//    89  ireturn
//    Stack map table: number of frames 5
//        [pc: 19, append: {int, int, java.util.ListIterator}]
//        [pc: 66, append: {int, java.lang.Comparable, int}]
//        [pc: 79, same]
//        [pc: 82, chop 3 local(s)]
//        [pc: 85, same]
//
//  // Method descriptor #394 (Ljava/util/ListIterator;I)Ljava/lang/Object;
//  // Signature: <T:Ljava/lang/Object;>(Ljava/util/ListIterator<+TT;>;I)TT;
//  // Stack: 2, Locals: 4
//  private static java.lang.Object get(java.util.ListIterator arg0, int arg1);
//     0  aconst_null
//     1  astore_2
//     2  aload_0 [arg0]
//     3  invokeinterface java.util.ListIterator.nextIndex() : int [626] [nargs: 1]
//     8  istore_3
//     9  iload_3
//    10  iload_1 [arg1]
//    11  if_icmpgt 32
//    14  aload_0 [arg0]
//    15  invokeinterface java.util.ListIterator.next() : java.lang.Object [627] [nargs: 1]
//    20  astore_2
//    21  iload_3
//    22  iinc 3 1
//    25  iload_1 [arg1]
//    26  if_icmplt 14
//    29  goto 47
//    32  aload_0 [arg0]
//    33  invokeinterface java.util.ListIterator.previous() : java.lang.Object [628] [nargs: 1]
//    38  astore_2
//    39  iinc 3 -1
//    42  iload_3
//    43  iload_1 [arg1]
//    44  if_icmpgt 32
//    47  aload_2
//    48  areturn
//    Stack map table: number of frames 3
//        [pc: 14, append: {java.lang.Object, int}]
//        [pc: 32, same]
//        [pc: 47, same]
//
//  // Method descriptor #430 (Ljava/util/List;Ljava/lang/Object;Ljava/util/Comparator;)I
//  // Signature: <T:Ljava/lang/Object;>(Ljava/util/List<+TT;>;TT;Ljava/util/Comparator<-TT;>;)I
//  // Stack: 3, Locals: 3
//  public static int binarySearch(java.util.List arg0, java.lang.Object arg1, java.util.Comparator arg2);
//     0  aload_2 [arg2]
//     1  ifnonnull 10
//     4  aload_0 [arg0]
//     5  aload_1 [arg1]
//     6  invokestatic java.util.Collections.binarySearch(java.util.List, java.lang.Object) : int [552]
//     9  ireturn
//    10  aload_0 [arg0]
//    11  instanceof java.util.RandomAccess [267]
//    14  ifne 29
//    17  aload_0 [arg0]
//    18  invokeinterface java.util.List.size() : int [618] [nargs: 1]
//    23  sipush 5000
//    26  if_icmpge 36
//    29  aload_0 [arg0]
//    30  aload_1 [arg1]
//    31  aload_2 [arg2]
//    32  invokestatic java.util.Collections.indexedBinarySearch(java.util.List, java.lang.Object, java.util.Comparator) : int [557]
//    35  ireturn
//    36  aload_0 [arg0]
//    37  aload_1 [arg1]
//    38  aload_2 [arg2]
//    39  invokestatic java.util.Collections.iteratorBinarySearch(java.util.List, java.lang.Object, java.util.Comparator) : int [558]
//    42  ireturn
//    Stack map table: number of frames 3
//        [pc: 10, same]
//        [pc: 29, same]
//        [pc: 36, same]
//
//  // Method descriptor #430 (Ljava/util/List;Ljava/lang/Object;Ljava/util/Comparator;)I
//  // Signature: <T:Ljava/lang/Object;>(Ljava/util/List<+TT;>;TT;Ljava/util/Comparator<-TT;>;)I
//  // Stack: 3, Locals: 8
//  private static int indexedBinarySearch(java.util.List arg0, java.lang.Object arg1, java.util.Comparator arg2);
//     0  iconst_0
//     1  istore_3
//     2  aload_0 [arg0]
//     3  invokeinterface java.util.List.size() : int [618] [nargs: 1]
//     8  iconst_1
//     9  isub
//    10  istore 4
//    12  iload_3
//    13  iload 4
//    15  if_icmpgt 80
//    18  iload_3
//    19  iload 4
//    21  iadd
//    22  iconst_1
//    23  iushr
//    24  istore 5
//    26  aload_0 [arg0]
//    27  iload 5
//    29  invokeinterface java.util.List.get(int) : java.lang.Object [620] [nargs: 2]
//    34  astore 6
//    36  aload_2 [arg2]
//    37  aload 6
//    39  aload_1 [arg1]
//    40  invokeinterface java.util.Comparator.compare(java.lang.Object, java.lang.Object) : int [613] [nargs: 3]
//    45  istore 7
//    47  iload 7
//    49  ifge 60
//    52  iload 5
//    54  iconst_1
//    55  iadd
//    56  istore_3
//    57  goto 77
//    60  iload 7
//    62  ifle 74
//    65  iload 5
//    67  iconst_1
//    68  isub
//    69  istore 4
//    71  goto 77
//    74  iload 5
//    76  ireturn
//    77  goto 12
//    80  iload_3
//    81  iconst_1
//    82  iadd
//    83  ineg
//    84  ireturn
//    Stack map table: number of frames 5
//        [pc: 12, append: {int, int}]
//        [pc: 60, append: {int, java.lang.Object, int}]
//        [pc: 74, same]
//        [pc: 77, chop 3 local(s)]
//        [pc: 80, same]
//
//  // Method descriptor #430 (Ljava/util/List;Ljava/lang/Object;Ljava/util/Comparator;)I
//  // Signature: <T:Ljava/lang/Object;>(Ljava/util/List<+TT;>;TT;Ljava/util/Comparator<-TT;>;)I
//  // Stack: 3, Locals: 9
//  private static int iteratorBinarySearch(java.util.List arg0, java.lang.Object arg1, java.util.Comparator arg2);
//     0  iconst_0
//     1  istore_3
//     2  aload_0 [arg0]
//     3  invokeinterface java.util.List.size() : int [618] [nargs: 1]
//     8  iconst_1
//     9  isub
//    10  istore 4
//    12  aload_0 [arg0]
//    13  invokeinterface java.util.List.listIterator() : java.util.ListIterator [623] [nargs: 1]
//    18  astore 5
//    20  iload_3
//    21  iload 4
//    23  if_icmpgt 87
//    26  iload_3
//    27  iload 4
//    29  iadd
//    30  iconst_1
//    31  iushr
//    32  istore 6
//    34  aload 5
//    36  iload 6
//    38  invokestatic java.util.Collections.get(java.util.ListIterator, int) : java.lang.Object [555]
//    41  astore 7
//    43  aload_2 [arg2]
//    44  aload 7
//    46  aload_1 [arg1]
//    47  invokeinterface java.util.Comparator.compare(java.lang.Object, java.lang.Object) : int [613] [nargs: 3]
//    52  istore 8
//    54  iload 8
//    56  ifge 67
//    59  iload 6
//    61  iconst_1
//    62  iadd
//    63  istore_3
//    64  goto 84
//    67  iload 8
//    69  ifle 81
//    72  iload 6
//    74  iconst_1
//    75  isub
//    76  istore 4
//    78  goto 84
//    81  iload 6
//    83  ireturn
//    84  goto 20
//    87  iload_3
//    88  iconst_1
//    89  iadd
//    90  ineg
//    91  ireturn
//    Stack map table: number of frames 5
//        [pc: 20, append: {int, int, java.util.ListIterator}]
//        [pc: 67, append: {int, java.lang.Object, int}]
//        [pc: 81, same]
//        [pc: 84, chop 3 local(s)]
//        [pc: 87, same]
//
//  // Method descriptor #357 (Ljava/util/List;)V
//  // Signature: (Ljava/util/List<*>;)V
//  // Stack: 3, Locals: 7
//  public static void reverse(java.util.List arg0);
//      0  aload_0 [arg0]
//      1  invokeinterface java.util.List.size() : int [618] [nargs: 1]
//      6  istore_1
//      7  iload_1
//      8  bipush 18
//     10  if_icmplt 20
//     13  aload_0 [arg0]
//     14  instanceof java.util.RandomAccess [267]
//     17  ifeq 55
//     20  iconst_0
//     21  istore_2
//     22  iload_1
//     23  iconst_1
//     24  ishr
//     25  istore_3
//     26  iload_1
//     27  iconst_1
//     28  isub
//     29  istore 4
//     31  iload_2
//     32  iload_3
//     33  if_icmpge 52
//     36  aload_0 [arg0]
//     37  iload_2
//     38  iload 4
//     40  invokestatic java.util.Collections.swap(java.util.List, int, int) : void [548]
//     43  iinc 2 1
//     46  iinc 4 -1
//     49  goto 31
//     52  goto 124
//     55  aload_0 [arg0]
//     56  invokeinterface java.util.List.listIterator() : java.util.ListIterator [623] [nargs: 1]
//     61  astore_2
//     62  aload_0 [arg0]
//     63  iload_1
//     64  invokeinterface java.util.List.listIterator(int) : java.util.ListIterator [624] [nargs: 2]
//     69  astore_3
//     70  iconst_0
//     71  istore 4
//     73  aload_0 [arg0]
//     74  invokeinterface java.util.List.size() : int [618] [nargs: 1]
//     79  iconst_1
//     80  ishr
//     81  istore 5
//     83  iload 4
//     85  iload 5
//     87  if_icmpge 124
//     90  aload_2
//     91  invokeinterface java.util.ListIterator.next() : java.lang.Object [627] [nargs: 1]
//     96  astore 6
//     98  aload_2
//     99  aload_3
//    100  invokeinterface java.util.ListIterator.previous() : java.lang.Object [628] [nargs: 1]
//    105  invokeinterface java.util.ListIterator.set(java.lang.Object) : void [629] [nargs: 2]
//    110  aload_3
//    111  aload 6
//    113  invokeinterface java.util.ListIterator.set(java.lang.Object) : void [629] [nargs: 2]
//    118  iinc 4 1
//    121  goto 83
//    124  return
//    Stack map table: number of frames 6
//        [pc: 20, append: {int}]
//        [pc: 31, append: {int, int, int}]
//        [pc: 52, chop 3 local(s)]
//        [pc: 55, same]
//        [pc: 83, full, stack: {}, locals: {java.util.List, int, java.util.ListIterator, java.util.ListIterator, int, int}]
//        [pc: 124, full, stack: {}, locals: {java.util.List, int}]
//
//  // Method descriptor #357 (Ljava/util/List;)V
//  // Signature: (Ljava/util/List<*>;)V
//  // Stack: 2, Locals: 2
//  public static void shuffle(java.util.List arg0);
//     0  getstatic java.util.Collections.r : java.util.Random [525]
//     3  astore_1
//     4  aload_1
//     5  ifnonnull 20
//     8  new java.util.Random [266]
//    11  dup
//    12  invokespecial java.util.Random() [606]
//    15  dup
//    16  astore_1
//    17  putstatic java.util.Collections.r : java.util.Random [525]
//    20  aload_0 [arg0]
//    21  aload_1
//    22  invokestatic java.util.Collections.shuffle(java.util.List, java.util.Random) : void [556]
//    25  return
//    Stack map table: number of frames 1
//        [pc: 20, append: {java.util.Random}]
//
//  // Method descriptor #415 (Ljava/util/List;Ljava/util/Random;)V
//  // Signature: (Ljava/util/List<*>;Ljava/util/Random;)V
//  // Stack: 4, Locals: 6
//  public static void shuffle(java.util.List arg0, java.util.Random arg1);
//      0  aload_0 [arg0]
//      1  invokeinterface java.util.List.size() : int [618] [nargs: 1]
//      6  istore_2
//      7  iload_2
//      8  iconst_5
//      9  if_icmplt 19
//     12  aload_0 [arg0]
//     13  instanceof java.util.RandomAccess [267]
//     16  ifeq 47
//     19  iload_2
//     20  istore_3
//     21  iload_3
//     22  iconst_1
//     23  if_icmple 44
//     26  aload_0 [arg0]
//     27  iload_3
//     28  iconst_1
//     29  isub
//     30  aload_1 [arg1]
//     31  iload_3
//     32  invokevirtual java.util.Random.nextInt(int) : int [607]
//     35  invokestatic java.util.Collections.swap(java.util.List, int, int) : void [548]
//     38  iinc 3 -1
//     41  goto 21
//     44  goto 126
//     47  aload_0 [arg0]
//     48  invokeinterface java.util.List.toArray() : java.lang.Object[] [619] [nargs: 1]
//     53  astore_3
//     54  iload_2
//     55  istore 4
//     57  iload 4
//     59  iconst_1
//     60  if_icmple 83
//     63  aload_3
//     64  iload 4
//     66  iconst_1
//     67  isub
//     68  aload_1 [arg1]
//     69  iload 4
//     71  invokevirtual java.util.Random.nextInt(int) : int [607]
//     74  invokestatic java.util.Collections.swap(java.lang.Object[], int, int) : void [543]
//     77  iinc 4 -1
//     80  goto 57
//     83  aload_0 [arg0]
//     84  invokeinterface java.util.List.listIterator() : java.util.ListIterator [623] [nargs: 1]
//     89  astore 4
//     91  iconst_0
//     92  istore 5
//     94  iload 5
//     96  aload_3
//     97  arraylength
//     98  if_icmpge 126
//    101  aload 4
//    103  invokeinterface java.util.ListIterator.next() : java.lang.Object [627] [nargs: 1]
//    108  pop
//    109  aload 4
//    111  aload_3
//    112  iload 5
//    114  aaload
//    115  invokeinterface java.util.ListIterator.set(java.lang.Object) : void [629] [nargs: 2]
//    120  iinc 5 1
//    123  goto 94
//    126  return
//    Stack map table: number of frames 8
//        [pc: 19, append: {int}]
//        [pc: 21, append: {int}]
//        [pc: 44, chop 1 local(s)]
//        [pc: 47, same]
//        [pc: 57, append: {java.lang.Object[], int}]
//        [pc: 83, chop 1 local(s)]
//        [pc: 94, append: {java.util.ListIterator, int}]
//        [pc: 126, chop 3 local(s)]
//
//  // Method descriptor #359 (Ljava/util/List;II)V
//  // Signature: (Ljava/util/List<*>;II)V
//  // Stack: 6, Locals: 4
//  public static void swap(java.util.List arg0, int arg1, int arg2);
//     0  aload_0 [arg0]
//     1  astore_3
//     2  aload_3
//     3  iload_1 [arg1]
//     4  aload_3
//     5  iload_2 [arg2]
//     6  aload_3
//     7  iload_1 [arg1]
//     8  invokeinterface java.util.List.get(int) : java.lang.Object [620] [nargs: 2]
//    13  invokeinterface java.util.List.set(int, java.lang.Object) : java.lang.Object [625] [nargs: 3]
//    18  invokeinterface java.util.List.set(int, java.lang.Object) : java.lang.Object [625] [nargs: 3]
//    23  pop
//    24  return
//
//
//  // Method descriptor #345 ([Ljava/lang/Object;II)V
//  // Stack: 4, Locals: 4
//  private static void swap(java.lang.Object[] arg0, int arg1, int arg2);
//     0  aload_0 [arg0]
//     1  iload_1 [arg1]
//     2  aaload
//     3  astore_3
//     4  aload_0 [arg0]
//     5  iload_1 [arg1]
//     6  aload_0 [arg0]
//     7  iload_2 [arg2]
//     8  aaload
//     9  aastore
//    10  aload_0 [arg0]
//    11  iload_2 [arg2]
//    12  aload_3
//    13  aastore
//    14  return
//
//
//  // Method descriptor #393 (Ljava/util/List;Ljava/lang/Object;)V
//  // Signature: <T:Ljava/lang/Object;>(Ljava/util/List<-TT;>;TT;)V
//  // Stack: 3, Locals: 5
//  public static void fill(java.util.List arg0, java.lang.Object arg1);
//     0  aload_0 [arg0]
//     1  invokeinterface java.util.List.size() : int [618] [nargs: 1]
//     6  istore_2
//     7  iload_2
//     8  bipush 25
//    10  if_icmplt 20
//    13  aload_0 [arg0]
//    14  instanceof java.util.RandomAccess [267]
//    17  ifeq 45
//    20  iconst_0
//    21  istore_3
//    22  iload_3
//    23  iload_2
//    24  if_icmpge 42
//    27  aload_0 [arg0]
//    28  iload_3
//    29  aload_1 [arg1]
//    30  invokeinterface java.util.List.set(int, java.lang.Object) : java.lang.Object [625] [nargs: 3]
//    35  pop
//    36  iinc 3 1
//    39  goto 22
//    42  goto 81
//    45  aload_0 [arg0]
//    46  invokeinterface java.util.List.listIterator() : java.util.ListIterator [623] [nargs: 1]
//    51  astore_3
//    52  iconst_0
//    53  istore 4
//    55  iload 4
//    57  iload_2
//    58  if_icmpge 81
//    61  aload_3
//    62  invokeinterface java.util.ListIterator.next() : java.lang.Object [627] [nargs: 1]
//    67  pop
//    68  aload_3
//    69  aload_1 [arg1]
//    70  invokeinterface java.util.ListIterator.set(java.lang.Object) : void [629] [nargs: 2]
//    75  iinc 4 1
//    78  goto 55
//    81  return
//    Stack map table: number of frames 6
//        [pc: 20, append: {int}]
//        [pc: 22, append: {int}]
//        [pc: 42, chop 1 local(s)]
//        [pc: 45, same]
//        [pc: 55, append: {java.util.ListIterator, int}]
//        [pc: 81, chop 2 local(s)]
//
//  // Method descriptor #409 (Ljava/util/List;Ljava/util/List;)V
//  // Signature: <T:Ljava/lang/Object;>(Ljava/util/List<-TT;>;Ljava/util/List<+TT;>;)V
//  // Stack: 4, Locals: 6
//  public static void copy(java.util.List arg0, java.util.List arg1);
//      0  aload_1 [arg1]
//      1  invokeinterface java.util.List.size() : int [618] [nargs: 1]
//      6  istore_2
//      7  iload_2
//      8  aload_0 [arg0]
//      9  invokeinterface java.util.List.size() : int [618] [nargs: 1]
//     14  if_icmple 27
//     17  new java.lang.IndexOutOfBoundsException [208]
//     20  dup
//     21  ldc <String "Source does not fit in dest"> [2]
//     23  invokespecial java.lang.IndexOutOfBoundsException(java.lang.String) [533]
//     26  athrow
//     27  iload_2
//     28  bipush 10
//     30  if_icmplt 47
//     33  aload_1 [arg1]
//     34  instanceof java.util.RandomAccess [267]
//     37  ifeq 78
//     40  aload_0 [arg0]
//     41  instanceof java.util.RandomAccess [267]
//     44  ifeq 78
//     47  iconst_0
//     48  istore_3
//     49  iload_3
//     50  iload_2
//     51  if_icmpge 75
//     54  aload_0 [arg0]
//     55  iload_3
//     56  aload_1 [arg1]
//     57  iload_3
//     58  invokeinterface java.util.List.get(int) : java.lang.Object [620] [nargs: 2]
//     63  invokeinterface java.util.List.set(int, java.lang.Object) : java.lang.Object [625] [nargs: 3]
//     68  pop
//     69  iinc 3 1
//     72  goto 49
//     75  goto 128
//     78  aload_0 [arg0]
//     79  invokeinterface java.util.List.listIterator() : java.util.ListIterator [623] [nargs: 1]
//     84  astore_3
//     85  aload_1 [arg1]
//     86  invokeinterface java.util.List.listIterator() : java.util.ListIterator [623] [nargs: 1]
//     91  astore 4
//     93  iconst_0
//     94  istore 5
//     96  iload 5
//     98  iload_2
//     99  if_icmpge 128
//    102  aload_3
//    103  invokeinterface java.util.ListIterator.next() : java.lang.Object [627] [nargs: 1]
//    108  pop
//    109  aload_3
//    110  aload 4
//    112  invokeinterface java.util.ListIterator.next() : java.lang.Object [627] [nargs: 1]
//    117  invokeinterface java.util.ListIterator.set(java.lang.Object) : void [629] [nargs: 2]
//    122  iinc 5 1
//    125  goto 96
//    128  return
//    Stack map table: number of frames 7
//        [pc: 27, append: {int}]
//        [pc: 47, same]
//        [pc: 49, append: {int}]
//        [pc: 75, chop 1 local(s)]
//        [pc: 78, same]
//        [pc: 96, append: {java.util.ListIterator, java.util.ListIterator, int}]
//        [pc: 128, chop 3 local(s)]
//
//  // Method descriptor #387 (Ljava/util/Collection;)Ljava/lang/Object;
//  // Signature: <T:Ljava/lang/Object;:Ljava/lang/Comparable<-TT;>;>(Ljava/util/Collection<+TT;>;)TT;
//  // Stack: 2, Locals: 4
//  public static java.lang.Object min(java.util.Collection arg0);
//     0  aload_0 [arg0]
//     1  invokeinterface java.util.Collection.iterator() : java.util.Iterator [612] [nargs: 1]
//     6  astore_1
//     7  aload_1
//     8  invokeinterface java.util.Iterator.next() : java.lang.Object [617] [nargs: 1]
//    13  astore_2
//    14  aload_1
//    15  invokeinterface java.util.Iterator.hasNext() : boolean [616] [nargs: 1]
//    20  ifeq 48
//    23  aload_1
//    24  invokeinterface java.util.Iterator.next() : java.lang.Object [617] [nargs: 1]
//    29  astore_3
//    30  aload_3
//    31  checkcast java.lang.Comparable [206]
//    34  aload_2
//    35  invokeinterface java.lang.Comparable.compareTo(java.lang.Object) : int [608] [nargs: 2]
//    40  ifge 45
//    43  aload_3
//    44  astore_2
//    45  goto 14
//    48  aload_2
//    49  areturn
//    Stack map table: number of frames 3
//        [pc: 14, append: {java.util.Iterator, java.lang.Object}]
//        [pc: 45, same]
//        [pc: 48, same]
//
//  // Method descriptor #427 (Ljava/util/Collection;Ljava/util/Comparator;)Ljava/lang/Object;
//  // Signature: <T:Ljava/lang/Object;>(Ljava/util/Collection<+TT;>;Ljava/util/Comparator<-TT;>;)TT;
//  // Stack: 3, Locals: 5
//  public static java.lang.Object min(java.util.Collection arg0, java.util.Comparator arg1);
//     0  aload_1 [arg1]
//     1  ifnonnull 9
//     4  aload_0 [arg0]
//     5  invokestatic java.util.Collections.min(java.util.Collection) : java.lang.Object [551]
//     8  areturn
//     9  aload_0 [arg0]
//    10  invokeinterface java.util.Collection.iterator() : java.util.Iterator [612] [nargs: 1]
//    15  astore_2
//    16  aload_2
//    17  invokeinterface java.util.Iterator.next() : java.lang.Object [617] [nargs: 1]
//    22  astore_3
//    23  aload_2
//    24  invokeinterface java.util.Iterator.hasNext() : boolean [616] [nargs: 1]
//    29  ifeq 58
//    32  aload_2
//    33  invokeinterface java.util.Iterator.next() : java.lang.Object [617] [nargs: 1]
//    38  astore 4
//    40  aload_1 [arg1]
//    41  aload 4
//    43  aload_3
//    44  invokeinterface java.util.Comparator.compare(java.lang.Object, java.lang.Object) : int [613] [nargs: 3]
//    49  ifge 55
//    52  aload 4
//    54  astore_3
//    55  goto 23
//    58  aload_3
//    59  areturn
//    Stack map table: number of frames 4
//        [pc: 9, same]
//        [pc: 23, append: {java.util.Iterator, java.lang.Object}]
//        [pc: 55, same]
//        [pc: 58, same]
//
//  // Method descriptor #387 (Ljava/util/Collection;)Ljava/lang/Object;
//  // Signature: <T:Ljava/lang/Object;:Ljava/lang/Comparable<-TT;>;>(Ljava/util/Collection<+TT;>;)TT;
//  // Stack: 2, Locals: 4
//  public static java.lang.Object max(java.util.Collection arg0);
//     0  aload_0 [arg0]
//     1  invokeinterface java.util.Collection.iterator() : java.util.Iterator [612] [nargs: 1]
//     6  astore_1
//     7  aload_1
//     8  invokeinterface java.util.Iterator.next() : java.lang.Object [617] [nargs: 1]
//    13  astore_2
//    14  aload_1
//    15  invokeinterface java.util.Iterator.hasNext() : boolean [616] [nargs: 1]
//    20  ifeq 48
//    23  aload_1
//    24  invokeinterface java.util.Iterator.next() : java.lang.Object [617] [nargs: 1]
//    29  astore_3
//    30  aload_3
//    31  checkcast java.lang.Comparable [206]
//    34  aload_2
//    35  invokeinterface java.lang.Comparable.compareTo(java.lang.Object) : int [608] [nargs: 2]
//    40  ifle 45
//    43  aload_3
//    44  astore_2
//    45  goto 14
//    48  aload_2
//    49  areturn
//    Stack map table: number of frames 3
//        [pc: 14, append: {java.util.Iterator, java.lang.Object}]
//        [pc: 45, same]
//        [pc: 48, same]
//
//  // Method descriptor #427 (Ljava/util/Collection;Ljava/util/Comparator;)Ljava/lang/Object;
//  // Signature: <T:Ljava/lang/Object;>(Ljava/util/Collection<+TT;>;Ljava/util/Comparator<-TT;>;)TT;
//  // Stack: 3, Locals: 5
//  public static java.lang.Object max(java.util.Collection arg0, java.util.Comparator arg1);
//     0  aload_1 [arg1]
//     1  ifnonnull 9
//     4  aload_0 [arg0]
//     5  invokestatic java.util.Collections.max(java.util.Collection) : java.lang.Object [550]
//     8  areturn
//     9  aload_0 [arg0]
//    10  invokeinterface java.util.Collection.iterator() : java.util.Iterator [612] [nargs: 1]
//    15  astore_2
//    16  aload_2
//    17  invokeinterface java.util.Iterator.next() : java.lang.Object [617] [nargs: 1]
//    22  astore_3
//    23  aload_2
//    24  invokeinterface java.util.Iterator.hasNext() : boolean [616] [nargs: 1]
//    29  ifeq 58
//    32  aload_2
//    33  invokeinterface java.util.Iterator.next() : java.lang.Object [617] [nargs: 1]
//    38  astore 4
//    40  aload_1 [arg1]
//    41  aload 4
//    43  aload_3
//    44  invokeinterface java.util.Comparator.compare(java.lang.Object, java.lang.Object) : int [613] [nargs: 3]
//    49  ifle 55
//    52  aload 4
//    54  astore_3
//    55  goto 23
//    58  aload_3
//    59  areturn
//    Stack map table: number of frames 4
//        [pc: 9, same]
//        [pc: 23, append: {java.util.Iterator, java.lang.Object}]
//        [pc: 55, same]
//        [pc: 58, same]
//
//  // Method descriptor #358 (Ljava/util/List;I)V
//  // Signature: (Ljava/util/List<*>;I)V
//  // Stack: 2, Locals: 2
//  public static void rotate(java.util.List arg0, int arg1);
//     0  aload_0 [arg0]
//     1  instanceof java.util.RandomAccess [267]
//     4  ifne 18
//     7  aload_0 [arg0]
//     8  invokeinterface java.util.List.size() : int [618] [nargs: 1]
//    13  bipush 100
//    15  if_icmpge 26
//    18  aload_0 [arg0]
//    19  iload_1 [arg1]
//    20  invokestatic java.util.Collections.rotate1(java.util.List, int) : void [546]
//    23  goto 31
//    26  aload_0 [arg0]
//    27  iload_1 [arg1]
//    28  invokestatic java.util.Collections.rotate2(java.util.List, int) : void [547]
//    31  return
//    Stack map table: number of frames 3
//        [pc: 18, same]
//        [pc: 26, same]
//        [pc: 31, same]
//
//  // Method descriptor #358 (Ljava/util/List;I)V
//  // Signature: <T:Ljava/lang/Object;>(Ljava/util/List<TT;>;I)V
//  // Stack: 3, Locals: 7
//  private static void rotate1(java.util.List arg0, int arg1);
//     0  aload_0 [arg0]
//     1  invokeinterface java.util.List.size() : int [618] [nargs: 1]
//     6  istore_2
//     7  iload_2
//     8  ifne 12
//    11  return
//    12  iload_1 [arg1]
//    13  iload_2
//    14  irem
//    15  istore_1 [arg1]
//    16  iload_1 [arg1]
//    17  ifge 24
//    20  iload_1 [arg1]
//    21  iload_2
//    22  iadd
//    23  istore_1 [arg1]
//    24  iload_1 [arg1]
//    25  ifne 29
//    28  return
//    29  iconst_0
//    30  istore_3
//    31  iconst_0
//    32  istore 4
//    34  iload 4
//    36  iload_2
//    37  if_icmpeq 97
//    40  aload_0 [arg0]
//    41  iload_3
//    42  invokeinterface java.util.List.get(int) : java.lang.Object [620] [nargs: 2]
//    47  astore 5
//    49  iload_3
//    50  istore 6
//    52  iload 6
//    54  iload_1 [arg1]
//    55  iadd
//    56  istore 6
//    58  iload 6
//    60  iload_2
//    61  if_icmplt 70
//    64  iload 6
//    66  iload_2
//    67  isub
//    68  istore 6
//    70  aload_0 [arg0]
//    71  iload 6
//    73  aload 5
//    75  invokeinterface java.util.List.set(int, java.lang.Object) : java.lang.Object [625] [nargs: 3]
//    80  astore 5
//    82  iinc 4 1
//    85  iload 6
//    87  iload_3
//    88  if_icmpne 52
//    91  iinc 3 1
//    94  goto 34
//    97  return
//    Stack map table: number of frames 7
//        [pc: 12, append: {int}]
//        [pc: 24, same]
//        [pc: 29, same]
//        [pc: 34, append: {int, int}]
//        [pc: 52, append: {java.lang.Object, int}]
//        [pc: 70, same]
//        [pc: 97, full, stack: {}, locals: {java.util.List, int, int}]
//
//  // Method descriptor #358 (Ljava/util/List;I)V
//  // Signature: (Ljava/util/List<*>;I)V
//  // Stack: 3, Locals: 4
//  private static void rotate2(java.util.List arg0, int arg1);
//     0  aload_0 [arg0]
//     1  invokeinterface java.util.List.size() : int [618] [nargs: 1]
//     6  istore_2
//     7  iload_2
//     8  ifne 12
//    11  return
//    12  iload_1 [arg1]
//    13  ineg
//    14  iload_2
//    15  irem
//    16  istore_3
//    17  iload_3
//    18  ifge 25
//    21  iload_3
//    22  iload_2
//    23  iadd
//    24  istore_3
//    25  iload_3
//    26  ifne 30
//    29  return
//    30  aload_0 [arg0]
//    31  iconst_0
//    32  iload_3
//    33  invokeinterface java.util.List.subList(int, int) : java.util.List [622] [nargs: 3]
//    38  invokestatic java.util.Collections.reverse(java.util.List) : void [545]
//    41  aload_0 [arg0]
//    42  iload_3
//    43  iload_2
//    44  invokeinterface java.util.List.subList(int, int) : java.util.List [622] [nargs: 3]
//    49  invokestatic java.util.Collections.reverse(java.util.List) : void [545]
//    52  aload_0 [arg0]
//    53  invokestatic java.util.Collections.reverse(java.util.List) : void [545]
//    56  return
//    Stack map table: number of frames 3
//        [pc: 12, append: {int}]
//        [pc: 25, append: {int}]
//        [pc: 30, same]
//
//  // Method descriptor #426 (Ljava/util/List;Ljava/lang/Object;Ljava/lang/Object;)Z
//  // Signature: <T:Ljava/lang/Object;>(Ljava/util/List<TT;>;TT;TT;)Z
//  // Stack: 3, Locals: 7
//  public static boolean replaceAll(java.util.List arg0, java.lang.Object arg1, java.lang.Object arg2);
//      0  iconst_0
//      1  istore_3
//      2  aload_0 [arg0]
//      3  invokeinterface java.util.List.size() : int [618] [nargs: 1]
//      8  istore 4
//     10  iload 4
//     12  bipush 11
//     14  if_icmplt 24
//     17  aload_0 [arg0]
//     18  instanceof java.util.RandomAccess [267]
//     21  ifeq 116
//     24  aload_1 [arg1]
//     25  ifnonnull 70
//     28  iconst_0
//     29  istore 5
//     31  iload 5
//     33  iload 4
//     35  if_icmpge 67
//     38  aload_0 [arg0]
//     39  iload 5
//     41  invokeinterface java.util.List.get(int) : java.lang.Object [620] [nargs: 2]
//     46  ifnonnull 61
//     49  aload_0 [arg0]
//     50  iload 5
//     52  aload_2 [arg2]
//     53  invokeinterface java.util.List.set(int, java.lang.Object) : java.lang.Object [625] [nargs: 3]
//     58  pop
//     59  iconst_1
//     60  istore_3
//     61  iinc 5 1
//     64  goto 31
//     67  goto 207
//     70  iconst_0
//     71  istore 5
//     73  iload 5
//     75  iload 4
//     77  if_icmpge 113
//     80  aload_1 [arg1]
//     81  aload_0 [arg0]
//     82  iload 5
//     84  invokeinterface java.util.List.get(int) : java.lang.Object [620] [nargs: 2]
//     89  invokevirtual java.lang.Object.equals(java.lang.Object) : boolean [535]
//     92  ifeq 107
//     95  aload_0 [arg0]
//     96  iload 5
//     98  aload_2 [arg2]
//     99  invokeinterface java.util.List.set(int, java.lang.Object) : java.lang.Object [625] [nargs: 3]
//    104  pop
//    105  iconst_1
//    106  istore_3
//    107  iinc 5 1
//    110  goto 73
//    113  goto 207
//    116  aload_0 [arg0]
//    117  invokeinterface java.util.List.listIterator() : java.util.ListIterator [623] [nargs: 1]
//    122  astore 5
//    124  aload_1 [arg1]
//    125  ifnonnull 167
//    128  iconst_0
//    129  istore 6
//    131  iload 6
//    133  iload 4
//    135  if_icmpge 164
//    138  aload 5
//    140  invokeinterface java.util.ListIterator.next() : java.lang.Object [627] [nargs: 1]
//    145  ifnonnull 158
//    148  aload 5
//    150  aload_2 [arg2]
//    151  invokeinterface java.util.ListIterator.set(java.lang.Object) : void [629] [nargs: 2]
//    156  iconst_1
//    157  istore_3
//    158  iinc 6 1
//    161  goto 131
//    164  goto 207
//    167  iconst_0
//    168  istore 6
//    170  iload 6
//    172  iload 4
//    174  if_icmpge 207
//    177  aload_1 [arg1]
//    178  aload 5
//    180  invokeinterface java.util.ListIterator.next() : java.lang.Object [627] [nargs: 1]
//    185  invokevirtual java.lang.Object.equals(java.lang.Object) : boolean [535]
//    188  ifeq 201
//    191  aload 5
//    193  aload_2 [arg2]
//    194  invokeinterface java.util.ListIterator.set(java.lang.Object) : void [629] [nargs: 2]
//    199  iconst_1
//    200  istore_3
//    201  iinc 6 1
//    204  goto 170
//    207  iload_3
//    208  ireturn
//    Stack map table: number of frames 16
//        [pc: 24, append: {int, int}]
//        [pc: 31, append: {int}]
//        [pc: 61, same]
//        [pc: 67, chop 1 local(s)]
//        [pc: 70, same]
//        [pc: 73, append: {int}]
//        [pc: 107, same]
//        [pc: 113, chop 1 local(s)]
//        [pc: 116, same]
//        [pc: 131, append: {java.util.ListIterator, int}]
//        [pc: 158, same]
//        [pc: 164, chop 1 local(s)]
//        [pc: 167, same]
//        [pc: 170, append: {int}]
//        [pc: 201, same]
//        [pc: 207, chop 2 local(s)]
//
//  // Method descriptor #408 (Ljava/util/List;Ljava/util/List;)I
//  // Signature: (Ljava/util/List<*>;Ljava/util/List<*>;)I
//  // Stack: 3, Locals: 10
//  public static int indexOfSubList(java.util.List arg0, java.util.List arg1);
//      0  aload_0 [arg0]
//      1  invokeinterface java.util.List.size() : int [618] [nargs: 1]
//      6  istore_2
//      7  aload_1 [arg1]
//      8  invokeinterface java.util.List.size() : int [618] [nargs: 1]
//     13  istore_3
//     14  iload_2
//     15  iload_3
//     16  isub
//     17  istore 4
//     19  iload_2
//     20  bipush 35
//     22  if_icmplt 39
//     25  aload_0 [arg0]
//     26  instanceof java.util.RandomAccess [267]
//     29  ifeq 108
//     32  aload_1 [arg1]
//     33  instanceof java.util.RandomAccess [267]
//     36  ifeq 108
//     39  iconst_0
//     40  istore 5
//     42  iload 5
//     44  iload 4
//     46  if_icmpgt 105
//     49  iconst_0
//     50  istore 6
//     52  iload 5
//     54  istore 7
//     56  iload 6
//     58  iload_3
//     59  if_icmpge 96
//     62  aload_1 [arg1]
//     63  iload 6
//     65  invokeinterface java.util.List.get(int) : java.lang.Object [620] [nargs: 2]
//     70  aload_0 [arg0]
//     71  iload 7
//     73  invokeinterface java.util.List.get(int) : java.lang.Object [620] [nargs: 2]
//     78  invokestatic java.util.Collections.eq(java.lang.Object, java.lang.Object) : boolean [549]
//     81  ifne 87
//     84  goto 99
//     87  iinc 6 1
//     90  iinc 7 1
//     93  goto 56
//     96  iload 5
//     98  ireturn
//     99  iinc 5 1
//    102  goto 42
//    105  goto 205
//    108  aload_0 [arg0]
//    109  invokeinterface java.util.List.listIterator() : java.util.ListIterator [623] [nargs: 1]
//    114  astore 5
//    116  iconst_0
//    117  istore 6
//    119  iload 6
//    121  iload 4
//    123  if_icmpgt 205
//    126  aload_1 [arg1]
//    127  invokeinterface java.util.List.listIterator() : java.util.ListIterator [623] [nargs: 1]
//    132  astore 7
//    134  iconst_0
//    135  istore 8
//    137  iload 8
//    139  iload_3
//    140  if_icmpge 196
//    143  aload 7
//    145  invokeinterface java.util.ListIterator.next() : java.lang.Object [627] [nargs: 1]
//    150  aload 5
//    152  invokeinterface java.util.ListIterator.next() : java.lang.Object [627] [nargs: 1]
//    157  invokestatic java.util.Collections.eq(java.lang.Object, java.lang.Object) : boolean [549]
//    160  ifne 190
//    163  iconst_0
//    164  istore 9
//    166  iload 9
//    168  iload 8
//    170  if_icmpge 187
//    173  aload 5
//    175  invokeinterface java.util.ListIterator.previous() : java.lang.Object [628] [nargs: 1]
//    180  pop
//    181  iinc 9 1
//    184  goto 166
//    187  goto 199
//    190  iinc 8 1
//    193  goto 137
//    196  iload 6
//    198  ireturn
//    199  iinc 6 1
//    202  goto 119
//    205  iconst_m1
//    206  ireturn
//    Stack map table: number of frames 16
//        [pc: 39, append: {int, int, int}]
//        [pc: 42, append: {int}]
//        [pc: 56, append: {int, int}]
//        [pc: 87, same]
//        [pc: 96, chop 2 local(s)]
//        [pc: 99, same]
//        [pc: 105, chop 1 local(s)]
//        [pc: 108, same]
//        [pc: 119, append: {java.util.ListIterator, int}]
//        [pc: 137, append: {java.util.ListIterator, int}]
//        [pc: 166, append: {int}]
//        [pc: 187, chop 1 local(s)]
//        [pc: 190, same]
//        [pc: 196, chop 1 local(s)]
//        [pc: 199, chop 1 local(s)]
//        [pc: 205, chop 2 local(s)]
//
//  // Method descriptor #408 (Ljava/util/List;Ljava/util/List;)I
//  // Signature: (Ljava/util/List<*>;Ljava/util/List<*>;)I
//  // Stack: 3, Locals: 10
//  public static int lastIndexOfSubList(java.util.List arg0, java.util.List arg1);
//      0  aload_0 [arg0]
//      1  invokeinterface java.util.List.size() : int [618] [nargs: 1]
//      6  istore_2
//      7  aload_1 [arg1]
//      8  invokeinterface java.util.List.size() : int [618] [nargs: 1]
//     13  istore_3
//     14  iload_2
//     15  iload_3
//     16  isub
//     17  istore 4
//     19  iload_2
//     20  bipush 35
//     22  if_icmplt 32
//     25  aload_0 [arg0]
//     26  instanceof java.util.RandomAccess [267]
//     29  ifeq 100
//     32  iload 4
//     34  istore 5
//     36  iload 5
//     38  iflt 97
//     41  iconst_0
//     42  istore 6
//     44  iload 5
//     46  istore 7
//     48  iload 6
//     50  iload_3
//     51  if_icmpge 88
//     54  aload_1 [arg1]
//     55  iload 6
//     57  invokeinterface java.util.List.get(int) : java.lang.Object [620] [nargs: 2]
//     62  aload_0 [arg0]
//     63  iload 7
//     65  invokeinterface java.util.List.get(int) : java.lang.Object [620] [nargs: 2]
//     70  invokestatic java.util.Collections.eq(java.lang.Object, java.lang.Object) : boolean [549]
//     73  ifne 79
//     76  goto 91
//     79  iinc 6 1
//     82  iinc 7 1
//     85  goto 48
//     88  iload 5
//     90  ireturn
//     91  iinc 5 -1
//     94  goto 36
//     97  goto 212
//    100  iload 4
//    102  ifge 107
//    105  iconst_m1
//    106  ireturn
//    107  aload_0 [arg0]
//    108  iload 4
//    110  invokeinterface java.util.List.listIterator(int) : java.util.ListIterator [624] [nargs: 2]
//    115  astore 5
//    117  iload 4
//    119  istore 6
//    121  iload 6
//    123  iflt 212
//    126  aload_1 [arg1]
//    127  invokeinterface java.util.List.listIterator() : java.util.ListIterator [623] [nargs: 1]
//    132  astore 7
//    134  iconst_0
//    135  istore 8
//    137  iload 8
//    139  iload_3
//    140  if_icmpge 203
//    143  aload 7
//    145  invokeinterface java.util.ListIterator.next() : java.lang.Object [627] [nargs: 1]
//    150  aload 5
//    152  invokeinterface java.util.ListIterator.next() : java.lang.Object [627] [nargs: 1]
//    157  invokestatic java.util.Collections.eq(java.lang.Object, java.lang.Object) : boolean [549]
//    160  ifne 197
//    163  iload 6
//    165  ifeq 206
//    168  iconst_0
//    169  istore 9
//    171  iload 9
//    173  iload 8
//    175  iconst_1
//    176  iadd
//    177  if_icmpgt 194
//    180  aload 5
//    182  invokeinterface java.util.ListIterator.previous() : java.lang.Object [628] [nargs: 1]
//    187  pop
//    188  iinc 9 1
//    191  goto 171
//    194  goto 206
//    197  iinc 8 1
//    200  goto 137
//    203  iload 6
//    205  ireturn
//    206  iinc 6 -1
//    209  goto 121
//    212  iconst_m1
//    213  ireturn
//    Stack map table: number of frames 17
//        [pc: 32, append: {int, int, int}]
//        [pc: 36, append: {int}]
//        [pc: 48, append: {int, int}]
//        [pc: 79, same]
//        [pc: 88, chop 2 local(s)]
//        [pc: 91, same]
//        [pc: 97, chop 1 local(s)]
//        [pc: 100, same]
//        [pc: 107, same]
//        [pc: 121, append: {java.util.ListIterator, int}]
//        [pc: 137, append: {java.util.ListIterator, int}]
//        [pc: 171, append: {int}]
//        [pc: 194, chop 1 local(s)]
//        [pc: 197, same]
//        [pc: 203, chop 1 local(s)]
//        [pc: 206, chop 1 local(s)]
//        [pc: 212, chop 2 local(s)]
//
//  // Method descriptor #398 (Ljava/util/Collection;)Ljava/util/Collection;
//  // Signature: <T:Ljava/lang/Object;>(Ljava/util/Collection<+TT;>;)Ljava/util/Collection<TT;>;
//  // Stack: 3, Locals: 1
//  public static java.util.Collection unmodifiableCollection(java.util.Collection arg0);
//    0  new java.util.Collections$UnmodifiableCollection [251]
//    3  dup
//    4  aload_0 [arg0]
//    5  invokespecial java.util.Collections$UnmodifiableCollection(java.util.Collection) [595]
//    8  areturn
//
//
//  // Method descriptor #419 (Ljava/util/Set;)Ljava/util/Set;
//  // Signature: <T:Ljava/lang/Object;>(Ljava/util/Set<+TT;>;)Ljava/util/Set<TT;>;
//  // Stack: 3, Locals: 1
//  public static java.util.Set unmodifiableSet(java.util.Set arg0);
//    0  new java.util.Collections$UnmodifiableSet [258]
//    3  dup
//    4  aload_0 [arg0]
//    5  invokespecial java.util.Collections$UnmodifiableSet(java.util.Set) [603]
//    8  areturn
//
//
//  // Method descriptor #421 (Ljava/util/SortedSet;)Ljava/util/SortedSet;
//  // Signature: <T:Ljava/lang/Object;>(Ljava/util/SortedSet<TT;>;)Ljava/util/SortedSet<TT;>;
//  // Stack: 3, Locals: 1
//  public static java.util.SortedSet unmodifiableSortedSet(java.util.SortedSet arg0);
//    0  new java.util.Collections$UnmodifiableSortedSet [260]
//    3  dup
//    4  aload_0 [arg0]
//    5  invokespecial java.util.Collections$UnmodifiableSortedSet(java.util.SortedSet) [605]
//    8  areturn
//
//
//  // Method descriptor #413 (Ljava/util/NavigableSet;)Ljava/util/NavigableSet;
//  // Signature: <T:Ljava/lang/Object;>(Ljava/util/NavigableSet<TT;>;)Ljava/util/NavigableSet<TT;>;
//  // Stack: 3, Locals: 1
//  public static java.util.NavigableSet unmodifiableNavigableSet(java.util.NavigableSet arg0);
//    0  new java.util.Collections$UnmodifiableNavigableSet [256]
//    3  dup
//    4  aload_0 [arg0]
//    5  invokespecial java.util.Collections$UnmodifiableNavigableSet(java.util.NavigableSet) [601]
//    8  areturn
//
//
//  // Method descriptor #407 (Ljava/util/List;)Ljava/util/List;
//  // Signature: <T:Ljava/lang/Object;>(Ljava/util/List<+TT;>;)Ljava/util/List<TT;>;
//  // Stack: 3, Locals: 1
//  public static java.util.List unmodifiableList(java.util.List arg0);
//     0  aload_0 [arg0]
//     1  instanceof java.util.RandomAccess [267]
//     4  ifeq 18
//     7  new java.util.Collections$UnmodifiableRandomAccessList [257]
//    10  dup
//    11  aload_0 [arg0]
//    12  invokespecial java.util.Collections$UnmodifiableRandomAccessList(java.util.List) [602]
//    15  goto 26
//    18  new java.util.Collections$UnmodifiableList [252]
//    21  dup
//    22  aload_0 [arg0]
//    23  invokespecial java.util.Collections$UnmodifiableList(java.util.List) [596]
//    26  areturn
//    Stack map table: number of frames 2
//        [pc: 18, same]
//        [pc: 26, same_locals_1_stack_item, stack: {java.util.List}]
//
//  // Method descriptor #411 (Ljava/util/Map;)Ljava/util/Map;
//  // Signature: <K:Ljava/lang/Object;V:Ljava/lang/Object;>(Ljava/util/Map<+TK;+TV;>;)Ljava/util/Map<TK;TV;>;
//  // Stack: 3, Locals: 1
//  public static java.util.Map unmodifiableMap(java.util.Map arg0);
//    0  new java.util.Collections$UnmodifiableMap [253]
//    3  dup
//    4  aload_0 [arg0]
//    5  invokespecial java.util.Collections$UnmodifiableMap(java.util.Map) [597]
//    8  areturn
//
//
//  // Method descriptor #420 (Ljava/util/SortedMap;)Ljava/util/SortedMap;
//  // Signature: <K:Ljava/lang/Object;V:Ljava/lang/Object;>(Ljava/util/SortedMap<TK;+TV;>;)Ljava/util/SortedMap<TK;TV;>;
//  // Stack: 3, Locals: 1
//  public static java.util.SortedMap unmodifiableSortedMap(java.util.SortedMap arg0);
//    0  new java.util.Collections$UnmodifiableSortedMap [259]
//    3  dup
//    4  aload_0 [arg0]
//    5  invokespecial java.util.Collections$UnmodifiableSortedMap(java.util.SortedMap) [604]
//    8  areturn
//
//
//  // Method descriptor #412 (Ljava/util/NavigableMap;)Ljava/util/NavigableMap;
//  // Signature: <K:Ljava/lang/Object;V:Ljava/lang/Object;>(Ljava/util/NavigableMap<TK;+TV;>;)Ljava/util/NavigableMap<TK;TV;>;
//  // Stack: 3, Locals: 1
//  public static java.util.NavigableMap unmodifiableNavigableMap(java.util.NavigableMap arg0);
//    0  new java.util.Collections$UnmodifiableNavigableMap [254]
//    3  dup
//    4  aload_0 [arg0]
//    5  invokespecial java.util.Collections$UnmodifiableNavigableMap(java.util.NavigableMap) [599]
//    8  areturn
//
//
//  // Method descriptor #398 (Ljava/util/Collection;)Ljava/util/Collection;
//  // Signature: <T:Ljava/lang/Object;>(Ljava/util/Collection<TT;>;)Ljava/util/Collection<TT;>;
//  // Stack: 3, Locals: 1
//  public static java.util.Collection synchronizedCollection(java.util.Collection arg0);
//    0  new java.util.Collections$SynchronizedCollection [242]
//    3  dup
//    4  aload_0 [arg0]
//    5  invokespecial java.util.Collections$SynchronizedCollection(java.util.Collection) [582]
//    8  areturn
//
//
//  // Method descriptor #429 (Ljava/util/Collection;Ljava/lang/Object;)Ljava/util/Collection;
//  // Signature: <T:Ljava/lang/Object;>(Ljava/util/Collection<TT;>;Ljava/lang/Object;)Ljava/util/Collection<TT;>;
//  // Stack: 4, Locals: 2
//  static java.util.Collection synchronizedCollection(java.util.Collection arg0, java.lang.Object arg1);
//     0  new java.util.Collections$SynchronizedCollection [242]
//     3  dup
//     4  aload_0 [arg0]
//     5  aload_1 [arg1]
//     6  invokespecial java.util.Collections$SynchronizedCollection(java.util.Collection, java.lang.Object) [583]
//     9  areturn
//
//
//  // Method descriptor #419 (Ljava/util/Set;)Ljava/util/Set;
//  // Signature: <T:Ljava/lang/Object;>(Ljava/util/Set<TT;>;)Ljava/util/Set<TT;>;
//  // Stack: 3, Locals: 1
//  public static java.util.Set synchronizedSet(java.util.Set arg0);
//    0  new java.util.Collections$SynchronizedSet [248]
//    3  dup
//    4  aload_0 [arg0]
//    5  invokespecial java.util.Collections$SynchronizedSet(java.util.Set) [591]
//    8  areturn
//
//
//  // Method descriptor #437 (Ljava/util/Set;Ljava/lang/Object;)Ljava/util/Set;
//  // Signature: <T:Ljava/lang/Object;>(Ljava/util/Set<TT;>;Ljava/lang/Object;)Ljava/util/Set<TT;>;
//  // Stack: 4, Locals: 2
//  static java.util.Set synchronizedSet(java.util.Set arg0, java.lang.Object arg1);
//     0  new java.util.Collections$SynchronizedSet [248]
//     3  dup
//     4  aload_0 [arg0]
//     5  aload_1 [arg1]
//     6  invokespecial java.util.Collections$SynchronizedSet(java.util.Set, java.lang.Object) [592]
//     9  areturn
//
//
//  // Method descriptor #421 (Ljava/util/SortedSet;)Ljava/util/SortedSet;
//  // Signature: <T:Ljava/lang/Object;>(Ljava/util/SortedSet<TT;>;)Ljava/util/SortedSet<TT;>;
//  // Stack: 3, Locals: 1
//  public static java.util.SortedSet synchronizedSortedSet(java.util.SortedSet arg0);
//    0  new java.util.Collections$SynchronizedSortedSet [250]
//    3  dup
//    4  aload_0 [arg0]
//    5  invokespecial java.util.Collections$SynchronizedSortedSet(java.util.SortedSet) [594]
//    8  areturn
//
//
//  // Method descriptor #413 (Ljava/util/NavigableSet;)Ljava/util/NavigableSet;
//  // Signature: <T:Ljava/lang/Object;>(Ljava/util/NavigableSet<TT;>;)Ljava/util/NavigableSet<TT;>;
//  // Stack: 3, Locals: 1
//  public static java.util.NavigableSet synchronizedNavigableSet(java.util.NavigableSet arg0);
//    0  new java.util.Collections$SynchronizedNavigableSet [246]
//    3  dup
//    4  aload_0 [arg0]
//    5  invokespecial java.util.Collections$SynchronizedNavigableSet(java.util.NavigableSet) [588]
//    8  areturn
//
//
//  // Method descriptor #407 (Ljava/util/List;)Ljava/util/List;
//  // Signature: <T:Ljava/lang/Object;>(Ljava/util/List<TT;>;)Ljava/util/List<TT;>;
//  // Stack: 3, Locals: 1
//  public static java.util.List synchronizedList(java.util.List arg0);
//     0  aload_0 [arg0]
//     1  instanceof java.util.RandomAccess [267]
//     4  ifeq 18
//     7  new java.util.Collections$SynchronizedRandomAccessList [247]
//    10  dup
//    11  aload_0 [arg0]
//    12  invokespecial java.util.Collections$SynchronizedRandomAccessList(java.util.List) [589]
//    15  goto 26
//    18  new java.util.Collections$SynchronizedList [243]
//    21  dup
//    22  aload_0 [arg0]
//    23  invokespecial java.util.Collections$SynchronizedList(java.util.List) [584]
//    26  areturn
//    Stack map table: number of frames 2
//        [pc: 18, same]
//        [pc: 26, same_locals_1_stack_item, stack: {java.util.List}]
//
//  // Method descriptor #432 (Ljava/util/List;Ljava/lang/Object;)Ljava/util/List;
//  // Signature: <T:Ljava/lang/Object;>(Ljava/util/List<TT;>;Ljava/lang/Object;)Ljava/util/List<TT;>;
//  // Stack: 4, Locals: 2
//  static java.util.List synchronizedList(java.util.List arg0, java.lang.Object arg1);
//     0  aload_0 [arg0]
//     1  instanceof java.util.RandomAccess [267]
//     4  ifeq 19
//     7  new java.util.Collections$SynchronizedRandomAccessList [247]
//    10  dup
//    11  aload_0 [arg0]
//    12  aload_1 [arg1]
//    13  invokespecial java.util.Collections$SynchronizedRandomAccessList(java.util.List, java.lang.Object) [590]
//    16  goto 28
//    19  new java.util.Collections$SynchronizedList [243]
//    22  dup
//    23  aload_0 [arg0]
//    24  aload_1 [arg1]
//    25  invokespecial java.util.Collections$SynchronizedList(java.util.List, java.lang.Object) [585]
//    28  areturn
//    Stack map table: number of frames 2
//        [pc: 19, same]
//        [pc: 28, same_locals_1_stack_item, stack: {java.util.List}]
//
//  // Method descriptor #411 (Ljava/util/Map;)Ljava/util/Map;
//  // Signature: <K:Ljava/lang/Object;V:Ljava/lang/Object;>(Ljava/util/Map<TK;TV;>;)Ljava/util/Map<TK;TV;>;
//  // Stack: 3, Locals: 1
//  public static java.util.Map synchronizedMap(java.util.Map arg0);
//    0  new java.util.Collections$SynchronizedMap [244]
//    3  dup
//    4  aload_0 [arg0]
//    5  invokespecial java.util.Collections$SynchronizedMap(java.util.Map) [586]
//    8  areturn
//
//
//  // Method descriptor #420 (Ljava/util/SortedMap;)Ljava/util/SortedMap;
//  // Signature: <K:Ljava/lang/Object;V:Ljava/lang/Object;>(Ljava/util/SortedMap<TK;TV;>;)Ljava/util/SortedMap<TK;TV;>;
//  // Stack: 3, Locals: 1
//  public static java.util.SortedMap synchronizedSortedMap(java.util.SortedMap arg0);
//    0  new java.util.Collections$SynchronizedSortedMap [249]
//    3  dup
//    4  aload_0 [arg0]
//    5  invokespecial java.util.Collections$SynchronizedSortedMap(java.util.SortedMap) [593]
//    8  areturn
//
//
//  // Method descriptor #412 (Ljava/util/NavigableMap;)Ljava/util/NavigableMap;
//  // Signature: <K:Ljava/lang/Object;V:Ljava/lang/Object;>(Ljava/util/NavigableMap<TK;TV;>;)Ljava/util/NavigableMap<TK;TV;>;
//  // Stack: 3, Locals: 1
//  public static java.util.NavigableMap synchronizedNavigableMap(java.util.NavigableMap arg0);
//    0  new java.util.Collections$SynchronizedNavigableMap [245]
//    3  dup
//    4  aload_0 [arg0]
//    5  invokespecial java.util.Collections$SynchronizedNavigableMap(java.util.NavigableMap) [587]
//    8  areturn
//
//
//  // Method descriptor #428 (Ljava/util/Collection;Ljava/lang/Class;)Ljava/util/Collection;
//  // Signature: <E:Ljava/lang/Object;>(Ljava/util/Collection<TE;>;Ljava/lang/Class<TE;>;)Ljava/util/Collection<TE;>;
//  // Stack: 4, Locals: 2
//  public static java.util.Collection checkedCollection(java.util.Collection arg0, java.lang.Class arg1);
//     0  new java.util.Collections$CheckedCollection [219]
//     3  dup
//     4  aload_0 [arg0]
//     5  aload_1 [arg1]
//     6  invokespecial java.util.Collections$CheckedCollection(java.util.Collection, java.lang.Class) [563]
//     9  areturn
//
//
//  // Method descriptor #383 (Ljava/lang/Class;)[Ljava/lang/Object;
//  // Signature: <T:Ljava/lang/Object;>(Ljava/lang/Class<TT;>;)[TT;
//  // Stack: 2, Locals: 1
//  static java.lang.Object[] zeroLengthArray(java.lang.Class arg0);
//     0  aload_0 [arg0]
//     1  iconst_0
//     2  invokestatic java.lang.reflect.Array.newInstance(java.lang.Class, int) : java.lang.Object [540]
//     5  checkcast java.lang.Object[] [205]
//     8  checkcast java.lang.Object[] [205]
//    11  areturn
//
//
//  // Method descriptor #435 (Ljava/util/Queue;Ljava/lang/Class;)Ljava/util/Queue;
//  // Signature: <E:Ljava/lang/Object;>(Ljava/util/Queue<TE;>;Ljava/lang/Class<TE;>;)Ljava/util/Queue<TE;>;
//  // Stack: 4, Locals: 2
//  public static java.util.Queue checkedQueue(java.util.Queue arg0, java.lang.Class arg1);
//     0  new java.util.Collections$CheckedQueue [224]
//     3  dup
//     4  aload_0 [arg0]
//     5  aload_1 [arg1]
//     6  invokespecial java.util.Collections$CheckedQueue(java.util.Queue, java.lang.Class) [568]
//     9  areturn
//
//
//  // Method descriptor #436 (Ljava/util/Set;Ljava/lang/Class;)Ljava/util/Set;
//  // Signature: <E:Ljava/lang/Object;>(Ljava/util/Set<TE;>;Ljava/lang/Class<TE;>;)Ljava/util/Set<TE;>;
//  // Stack: 4, Locals: 2
//  public static java.util.Set checkedSet(java.util.Set arg0, java.lang.Class arg1);
//     0  new java.util.Collections$CheckedSet [226]
//     3  dup
//     4  aload_0 [arg0]
//     5  aload_1 [arg1]
//     6  invokespecial java.util.Collections$CheckedSet(java.util.Set, java.lang.Class) [570]
//     9  areturn
//
//
//  // Method descriptor #438 (Ljava/util/SortedSet;Ljava/lang/Class;)Ljava/util/SortedSet;
//  // Signature: <E:Ljava/lang/Object;>(Ljava/util/SortedSet<TE;>;Ljava/lang/Class<TE;>;)Ljava/util/SortedSet<TE;>;
//  // Stack: 4, Locals: 2
//  public static java.util.SortedSet checkedSortedSet(java.util.SortedSet arg0, java.lang.Class arg1);
//     0  new java.util.Collections$CheckedSortedSet [228]
//     3  dup
//     4  aload_0 [arg0]
//     5  aload_1 [arg1]
//     6  invokespecial java.util.Collections$CheckedSortedSet(java.util.SortedSet, java.lang.Class) [572]
//     9  areturn
//
//
//  // Method descriptor #434 (Ljava/util/NavigableSet;Ljava/lang/Class;)Ljava/util/NavigableSet;
//  // Signature: <E:Ljava/lang/Object;>(Ljava/util/NavigableSet<TE;>;Ljava/lang/Class<TE;>;)Ljava/util/NavigableSet<TE;>;
//  // Stack: 4, Locals: 2
//  public static java.util.NavigableSet checkedNavigableSet(java.util.NavigableSet arg0, java.lang.Class arg1);
//     0  new java.util.Collections$CheckedNavigableSet [223]
//     3  dup
//     4  aload_0 [arg0]
//     5  aload_1 [arg1]
//     6  invokespecial java.util.Collections$CheckedNavigableSet(java.util.NavigableSet, java.lang.Class) [567]
//     9  areturn
//
//
//  // Method descriptor #431 (Ljava/util/List;Ljava/lang/Class;)Ljava/util/List;
//  // Signature: <E:Ljava/lang/Object;>(Ljava/util/List<TE;>;Ljava/lang/Class<TE;>;)Ljava/util/List<TE;>;
//  // Stack: 4, Locals: 2
//  public static java.util.List checkedList(java.util.List arg0, java.lang.Class arg1);
//     0  aload_0 [arg0]
//     1  instanceof java.util.RandomAccess [267]
//     4  ifeq 19
//     7  new java.util.Collections$CheckedRandomAccessList [225]
//    10  dup
//    11  aload_0 [arg0]
//    12  aload_1 [arg1]
//    13  invokespecial java.util.Collections$CheckedRandomAccessList(java.util.List, java.lang.Class) [569]
//    16  goto 28
//    19  new java.util.Collections$CheckedList [220]
//    22  dup
//    23  aload_0 [arg0]
//    24  aload_1 [arg1]
//    25  invokespecial java.util.Collections$CheckedList(java.util.List, java.lang.Class) [564]
//    28  areturn
//    Stack map table: number of frames 2
//        [pc: 19, same]
//        [pc: 28, same_locals_1_stack_item, stack: {java.util.List}]
//
//  // Method descriptor #439 (Ljava/util/Map;Ljava/lang/Class;Ljava/lang/Class;)Ljava/util/Map;
//  // Signature: <K:Ljava/lang/Object;V:Ljava/lang/Object;>(Ljava/util/Map<TK;TV;>;Ljava/lang/Class<TK;>;Ljava/lang/Class<TV;>;)Ljava/util/Map<TK;TV;>;
//  // Stack: 5, Locals: 3
//  public static java.util.Map checkedMap(java.util.Map arg0, java.lang.Class arg1, java.lang.Class arg2);
//     0  new java.util.Collections$CheckedMap [221]
//     3  dup
//     4  aload_0 [arg0]
//     5  aload_1 [arg1]
//     6  aload_2 [arg2]
//     7  invokespecial java.util.Collections$CheckedMap(java.util.Map, java.lang.Class, java.lang.Class) [565]
//    10  areturn
//
//
//  // Method descriptor #441 (Ljava/util/SortedMap;Ljava/lang/Class;Ljava/lang/Class;)Ljava/util/SortedMap;
//  // Signature: <K:Ljava/lang/Object;V:Ljava/lang/Object;>(Ljava/util/SortedMap<TK;TV;>;Ljava/lang/Class<TK;>;Ljava/lang/Class<TV;>;)Ljava/util/SortedMap<TK;TV;>;
//  // Stack: 5, Locals: 3
//  public static java.util.SortedMap checkedSortedMap(java.util.SortedMap arg0, java.lang.Class arg1, java.lang.Class arg2);
//     0  new java.util.Collections$CheckedSortedMap [227]
//     3  dup
//     4  aload_0 [arg0]
//     5  aload_1 [arg1]
//     6  aload_2 [arg2]
//     7  invokespecial java.util.Collections$CheckedSortedMap(java.util.SortedMap, java.lang.Class, java.lang.Class) [571]
//    10  areturn
//
//
//  // Method descriptor #440 (Ljava/util/NavigableMap;Ljava/lang/Class;Ljava/lang/Class;)Ljava/util/NavigableMap;
//  // Signature: <K:Ljava/lang/Object;V:Ljava/lang/Object;>(Ljava/util/NavigableMap<TK;TV;>;Ljava/lang/Class<TK;>;Ljava/lang/Class<TV;>;)Ljava/util/NavigableMap<TK;TV;>;
//  // Stack: 5, Locals: 3
//  public static java.util.NavigableMap checkedNavigableMap(java.util.NavigableMap arg0, java.lang.Class arg1, java.lang.Class arg2);
//     0  new java.util.Collections$CheckedNavigableMap [222]
//     3  dup
//     4  aload_0 [arg0]
//     5  aload_1 [arg1]
//     6  aload_2 [arg2]
//     7  invokespecial java.util.Collections$CheckedNavigableMap(java.util.NavigableMap, java.lang.Class, java.lang.Class) [566]
//    10  areturn
//
//
//  // Method descriptor #354 ()Ljava/util/Iterator;
//  // Signature: <T:Ljava/lang/Object;>()Ljava/util/Iterator<TT;>;
//  // Stack: 1, Locals: 0
//  public static java.util.Iterator emptyIterator();
//    0  getstatic java.util.Collections$EmptyIterator.EMPTY_ITERATOR : java.util.Collections.EmptyIterator [528]
//    3  areturn
//
//
//  // Method descriptor #363 ()Ljava/util/ListIterator;
//  // Signature: <T:Ljava/lang/Object;>()Ljava/util/ListIterator<TT;>;
//  // Stack: 1, Locals: 0
//  public static java.util.ListIterator emptyListIterator();
//    0  getstatic java.util.Collections$EmptyListIterator.EMPTY_ITERATOR : java.util.Collections.EmptyListIterator [529]
//    3  areturn
//
//
//  // Method descriptor #353 ()Ljava/util/Enumeration;
//  // Signature: <T:Ljava/lang/Object;>()Ljava/util/Enumeration<TT;>;
//  // Stack: 1, Locals: 0
//  public static java.util.Enumeration emptyEnumeration();
//    0  getstatic java.util.Collections$EmptyEnumeration.EMPTY_ENUMERATION : java.util.Collections.EmptyEnumeration [527]
//    3  areturn
//
//
//  // Method descriptor #371 ()Ljava/util/Set;
//  // Signature: <T:Ljava/lang/Object;>()Ljava/util/Set<TT;>;
//  // Stack: 1, Locals: 0
//  public static final java.util.Set emptySet();
//    0  getstatic java.util.Collections.EMPTY_SET : java.util.Set [526]
//    3  areturn
//
//
//  // Method descriptor #375 ()Ljava/util/SortedSet;
//  // Signature: <E:Ljava/lang/Object;>()Ljava/util/SortedSet<TE;>;
//  // Stack: 1, Locals: 0
//  public static java.util.SortedSet emptySortedSet();
//    0  invokestatic java.util.Collections$UnmodifiableNavigableSet.access$000() : java.util.NavigableSet [600]
//    3  areturn
//
//
//  // Method descriptor #369 ()Ljava/util/NavigableSet;
//  // Signature: <E:Ljava/lang/Object;>()Ljava/util/NavigableSet<TE;>;
//  // Stack: 1, Locals: 0
//  public static java.util.NavigableSet emptyNavigableSet();
//    0  invokestatic java.util.Collections$UnmodifiableNavigableSet.access$000() : java.util.NavigableSet [600]
//    3  areturn
//
//
//  // Method descriptor #355 ()Ljava/util/List;
//  // Signature: <T:Ljava/lang/Object;>()Ljava/util/List<TT;>;
//  // Stack: 1, Locals: 0
//  public static final java.util.List emptyList();
//    0  getstatic java.util.Collections.EMPTY_LIST : java.util.List [523]
//    3  areturn
//
//
//  // Method descriptor #365 ()Ljava/util/Map;
//  // Signature: <K:Ljava/lang/Object;V:Ljava/lang/Object;>()Ljava/util/Map<TK;TV;>;
//  // Stack: 1, Locals: 0
//  public static final java.util.Map emptyMap();
//    0  getstatic java.util.Collections.EMPTY_MAP : java.util.Map [524]
//    3  areturn
//
//
//  // Method descriptor #373 ()Ljava/util/SortedMap;
//  // Signature: <K:Ljava/lang/Object;V:Ljava/lang/Object;>()Ljava/util/SortedMap<TK;TV;>;
//  // Stack: 1, Locals: 0
//  public static final java.util.SortedMap emptySortedMap();
//    0  invokestatic java.util.Collections$UnmodifiableNavigableMap.access$100() : java.util.Collections$UnmodifiableNavigableMap$EmptyNavigableMap [598]
//    3  areturn
//
//
//  // Method descriptor #367 ()Ljava/util/NavigableMap;
//  // Signature: <K:Ljava/lang/Object;V:Ljava/lang/Object;>()Ljava/util/NavigableMap<TK;TV;>;
//  // Stack: 1, Locals: 0
//  public static final java.util.NavigableMap emptyNavigableMap();
//    0  invokestatic java.util.Collections$UnmodifiableNavigableMap.access$100() : java.util.Collections$UnmodifiableNavigableMap$EmptyNavigableMap [598]
//    3  areturn
//
//
//  // Method descriptor #417 (Ljava/lang/Object;)Ljava/util/Set;
//  // Signature: <T:Ljava/lang/Object;>(TT;)Ljava/util/Set<TT;>;
//  // Stack: 3, Locals: 1
//  public static java.util.Set singleton(java.lang.Object arg0);
//    0  new java.util.Collections$SingletonSet [241]
//    3  dup
//    4  aload_0 [arg0]
//    5  invokespecial java.util.Collections$SingletonSet(java.lang.Object) [581]
//    8  areturn
//
//
//  // Method descriptor #404 (Ljava/lang/Object;)Ljava/util/Iterator;
//  // Signature: <E:Ljava/lang/Object;>(TE;)Ljava/util/Iterator<TE;>;
//  // Stack: 3, Locals: 1
//  static java.util.Iterator singletonIterator(java.lang.Object arg0);
//    0  new java.util.Collections$1 [215]
//    3  dup
//    4  aload_0 [arg0]
//    5  invokespecial java.util.Collections$1(java.lang.Object) [559]
//    8  areturn
//
//
//  // Method descriptor #422 (Ljava/lang/Object;)Ljava/util/Spliterator;
//  // Signature: <T:Ljava/lang/Object;>(TT;)Ljava/util/Spliterator<TT;>;
//  // Stack: 3, Locals: 1
//  static java.util.Spliterator singletonSpliterator(java.lang.Object arg0);
//    0  new java.util.Collections$2 [216]
//    3  dup
//    4  aload_0 [arg0]
//    5  invokespecial java.util.Collections$2(java.lang.Object) [560]
//    8  areturn
//
//
//  // Method descriptor #406 (Ljava/lang/Object;)Ljava/util/List;
//  // Signature: <T:Ljava/lang/Object;>(TT;)Ljava/util/List<TT;>;
//  // Stack: 3, Locals: 1
//  public static java.util.List singletonList(java.lang.Object arg0);
//    0  new java.util.Collections$SingletonList [239]
//    3  dup
//    4  aload_0 [arg0]
//    5  invokespecial java.util.Collections$SingletonList(java.lang.Object) [579]
//    8  areturn
//
//
//  // Method descriptor #433 (Ljava/lang/Object;Ljava/lang/Object;)Ljava/util/Map;
//  // Signature: <K:Ljava/lang/Object;V:Ljava/lang/Object;>(TK;TV;)Ljava/util/Map<TK;TV;>;
//  // Stack: 4, Locals: 2
//  public static java.util.Map singletonMap(java.lang.Object arg0, java.lang.Object arg1);
//     0  new java.util.Collections$SingletonMap [240]
//     3  dup
//     4  aload_0 [arg0]
//     5  aload_1 [arg1]
//     6  invokespecial java.util.Collections$SingletonMap(java.lang.Object, java.lang.Object) [580]
//     9  areturn
//
//
//  // Method descriptor #405 (ILjava/lang/Object;)Ljava/util/List;
//  // Signature: <T:Ljava/lang/Object;>(ITT;)Ljava/util/List<TT;>;
//  // Stack: 4, Locals: 2
//  public static java.util.List nCopies(int arg0, java.lang.Object arg1);
//     0  iload_0 [arg0]
//     1  ifge 31
//     4  new java.lang.IllegalArgumentException [207]
//     7  dup
//     8  new java.lang.StringBuilder [210]
//    11  dup
//    12  invokespecial java.lang.StringBuilder() [536]
//    15  ldc <String "List length = "> [1]
//    17  invokevirtual java.lang.StringBuilder.append(java.lang.String) : java.lang.StringBuilder [539]
//    20  iload_0 [arg0]
//    21  invokevirtual java.lang.StringBuilder.append(int) : java.lang.StringBuilder [538]
//    24  invokevirtual java.lang.StringBuilder.toString() : java.lang.String [537]
//    27  invokespecial java.lang.IllegalArgumentException(java.lang.String) [532]
//    30  athrow
//    31  new java.util.Collections$CopiesList [229]
//    34  dup
//    35  iload_0 [arg0]
//    36  aload_1 [arg1]
//    37  invokespecial java.util.Collections$CopiesList(int, java.lang.Object) [573]
//    40  areturn
//    Stack map table: number of frames 1
//        [pc: 31, same]
//
//  // Method descriptor #350 ()Ljava/util/Comparator;
//  // Signature: <T:Ljava/lang/Object;>()Ljava/util/Comparator<TT;>;
//  // Stack: 1, Locals: 0
//  public static java.util.Comparator reverseOrder();
//    0  getstatic java.util.Collections$ReverseComparator.REVERSE_ORDER : java.util.Collections.ReverseComparator [530]
//    3  areturn
//
//
//  // Method descriptor #401 (Ljava/util/Comparator;)Ljava/util/Comparator;
//  // Signature: <T:Ljava/lang/Object;>(Ljava/util/Comparator<TT;>;)Ljava/util/Comparator<TT;>;
//  // Stack: 3, Locals: 1
//  public static java.util.Comparator reverseOrder(java.util.Comparator arg0);
//     0  aload_0 [arg0]
//     1  ifnonnull 8
//     4  invokestatic java.util.Collections.reverseOrder() : java.util.Comparator [544]
//     7  areturn
//     8  aload_0 [arg0]
//     9  instanceof java.util.Collections$ReverseComparator2 [237]
//    12  ifeq 23
//    15  aload_0 [arg0]
//    16  checkcast java.util.Collections$ReverseComparator2 [237]
//    19  getfield java.util.Collections$ReverseComparator2.cmp : java.util.Comparator [531]
//    22  areturn
//    23  new java.util.Collections$ReverseComparator2 [237]
//    26  dup
//    27  aload_0 [arg0]
//    28  invokespecial java.util.Collections$ReverseComparator2(java.util.Comparator) [577]
//    31  areturn
//    Stack map table: number of frames 2
//        [pc: 8, same]
//        [pc: 23, same]
//
//  // Method descriptor #403 (Ljava/util/Collection;)Ljava/util/Enumeration;
//  // Signature: <T:Ljava/lang/Object;>(Ljava/util/Collection<TT;>;)Ljava/util/Enumeration<TT;>;
//  // Stack: 3, Locals: 1
//  public static java.util.Enumeration enumeration(java.util.Collection arg0);
//    0  new java.util.Collections$3 [217]
//    3  dup
//    4  aload_0 [arg0]
//    5  invokespecial java.util.Collections$3(java.util.Collection) [561]
//    8  areturn
//
//
//  // Method descriptor #397 (Ljava/util/Enumeration;)Ljava/util/ArrayList;
//  // Signature: <T:Ljava/lang/Object;>(Ljava/util/Enumeration<TT;>;)Ljava/util/ArrayList<TT;>;
//  // Stack: 2, Locals: 2
//  public static java.util.ArrayList list(java.util.Enumeration arg0);
//     0  new java.util.ArrayList [212]
//     3  dup
//     4  invokespecial java.util.ArrayList() [541]
//     7  astore_1
//     8  aload_0 [arg0]
//     9  invokeinterface java.util.Enumeration.hasMoreElements() : boolean [614] [nargs: 1]
//    14  ifeq 31
//    17  aload_1
//    18  aload_0 [arg0]
//    19  invokeinterface java.util.Enumeration.nextElement() : java.lang.Object [615] [nargs: 1]
//    24  invokevirtual java.util.ArrayList.add(java.lang.Object) : boolean [542]
//    27  pop
//    28  goto 8
//    31  aload_1
//    32  areturn
//    Stack map table: number of frames 2
//        [pc: 8, append: {java.util.ArrayList}]
//        [pc: 31, same]
//
//  // Method descriptor #386 (Ljava/lang/Object;Ljava/lang/Object;)Z
//  // Stack: 2, Locals: 2
//  static boolean eq(java.lang.Object arg0, java.lang.Object arg1);
//     0  aload_0 [arg0]
//     1  ifnonnull 16
//     4  aload_1 [arg1]
//     5  ifnonnull 12
//     8  iconst_1
//     9  goto 21
//    12  iconst_0
//    13  goto 21
//    16  aload_0 [arg0]
//    17  aload_1 [arg1]
//    18  invokevirtual java.lang.Object.equals(java.lang.Object) : boolean [535]
//    21  ireturn
//    Stack map table: number of frames 3
//        [pc: 12, same]
//        [pc: 16, same]
//        [pc: 21, same_locals_1_stack_item, stack: {int}]
//
//  // Method descriptor #388 (Ljava/util/Collection;Ljava/lang/Object;)I
//  // Signature: (Ljava/util/Collection<*>;Ljava/lang/Object;)I
//  // Stack: 2, Locals: 5
//  public static int frequency(java.util.Collection arg0, java.lang.Object arg1);
//     0  iconst_0
//     1  istore_2
//     2  aload_1 [arg1]
//     3  ifnonnull 44
//     6  aload_0 [arg0]
//     7  invokeinterface java.util.Collection.iterator() : java.util.Iterator [612] [nargs: 1]
//    12  astore_3
//    13  aload_3
//    14  invokeinterface java.util.Iterator.hasNext() : boolean [616] [nargs: 1]
//    19  ifeq 41
//    22  aload_3
//    23  invokeinterface java.util.Iterator.next() : java.lang.Object [617] [nargs: 1]
//    28  astore 4
//    30  aload 4
//    32  ifnonnull 38
//    35  iinc 2 1
//    38  goto 13
//    41  goto 83
//    44  aload_0 [arg0]
//    45  invokeinterface java.util.Collection.iterator() : java.util.Iterator [612] [nargs: 1]
//    50  astore_3
//    51  aload_3
//    52  invokeinterface java.util.Iterator.hasNext() : boolean [616] [nargs: 1]
//    57  ifeq 83
//    60  aload_3
//    61  invokeinterface java.util.Iterator.next() : java.lang.Object [617] [nargs: 1]
//    66  astore 4
//    68  aload_1 [arg1]
//    69  aload 4
//    71  invokevirtual java.lang.Object.equals(java.lang.Object) : boolean [535]
//    74  ifeq 80
//    77  iinc 2 1
//    80  goto 51
//    83  iload_2
//    84  ireturn
//    Stack map table: number of frames 7
//        [pc: 13, append: {int, java.util.Iterator}]
//        [pc: 38, same]
//        [pc: 41, chop 1 local(s)]
//        [pc: 44, same]
//        [pc: 51, append: {java.util.Iterator}]
//        [pc: 80, same]
//        [pc: 83, chop 1 local(s)]
//
//  // Method descriptor #399 (Ljava/util/Collection;Ljava/util/Collection;)Z
//  // Signature: (Ljava/util/Collection<*>;Ljava/util/Collection<*>;)Z
//  // Stack: 2, Locals: 6
//  public static boolean disjoint(java.util.Collection arg0, java.util.Collection arg1);
//      0  aload_1 [arg1]
//      1  astore_2
//      2  aload_0 [arg0]
//      3  astore_3
//      4  aload_0 [arg0]
//      5  instanceof java.util.Set [268]
//      8  ifeq 18
//     11  aload_1 [arg1]
//     12  astore_3
//     13  aload_0 [arg0]
//     14  astore_2
//     15  goto 64
//     18  aload_1 [arg1]
//     19  instanceof java.util.Set [268]
//     22  ifne 64
//     25  aload_0 [arg0]
//     26  invokeinterface java.util.Collection.size() : int [609] [nargs: 1]
//     31  istore 4
//     33  aload_1 [arg1]
//     34  invokeinterface java.util.Collection.size() : int [609] [nargs: 1]
//     39  istore 5
//     41  iload 4
//     43  ifeq 51
//     46  iload 5
//     48  ifne 53
//     51  iconst_1
//     52  ireturn
//     53  iload 4
//     55  iload 5
//     57  if_icmple 64
//     60  aload_1 [arg1]
//     61  astore_3
//     62  aload_0 [arg0]
//     63  astore_2
//     64  aload_3
//     65  invokeinterface java.util.Collection.iterator() : java.util.Iterator [612] [nargs: 1]
//     70  astore 4
//     72  aload 4
//     74  invokeinterface java.util.Iterator.hasNext() : boolean [616] [nargs: 1]
//     79  ifeq 107
//     82  aload 4
//     84  invokeinterface java.util.Iterator.next() : java.lang.Object [617] [nargs: 1]
//     89  astore 5
//     91  aload_2
//     92  aload 5
//     94  invokeinterface java.util.Collection.contains(java.lang.Object) : boolean [611] [nargs: 2]
//     99  ifeq 104
//    102  iconst_0
//    103  ireturn
//    104  goto 72
//    107  iconst_1
//    108  ireturn
//    Stack map table: number of frames 7
//        [pc: 18, append: {java.util.Collection, java.util.Collection}]
//        [pc: 51, append: {int, int}]
//        [pc: 53, same]
//        [pc: 64, chop 2 local(s)]
//        [pc: 72, append: {java.util.Iterator}]
//        [pc: 104, same]
//        [pc: 107, chop 1 local(s)]
//
//  // Method descriptor #390 (Ljava/util/Collection;[Ljava/lang/Object;)Z
//  // Signature: <T:Ljava/lang/Object;>(Ljava/util/Collection<-TT;>;[TT;)Z
//  // Stack: 3, Locals: 7
//  @java.lang.SafeVarargs
//  public static boolean addAll(java.util.Collection arg0, java.lang.Object... arg1);
//     0  iconst_0
//     1  istore_2
//     2  aload_1 [arg1]
//     3  astore_3
//     4  aload_3
//     5  arraylength
//     6  istore 4
//     8  iconst_0
//     9  istore 5
//    11  iload 5
//    13  iload 4
//    15  if_icmpge 41
//    18  aload_3
//    19  iload 5
//    21  aaload
//    22  astore 6
//    24  iload_2
//    25  aload_0 [arg0]
//    26  aload 6
//    28  invokeinterface java.util.Collection.add(java.lang.Object) : boolean [610] [nargs: 2]
//    33  ior
//    34  istore_2
//    35  iinc 5 1
//    38  goto 11
//    41  iload_2
//    42  ireturn
//    Stack map table: number of frames 2
//        [pc: 11, full, stack: {}, locals: {java.util.Collection, java.lang.Object[], int, java.lang.Object[], int, int}]
//        [pc: 41, chop 3 local(s)]
//
//  // Method descriptor #418 (Ljava/util/Map;)Ljava/util/Set;
//  // Signature: <E:Ljava/lang/Object;>(Ljava/util/Map<TE;Ljava/lang/Boolean;>;)Ljava/util/Set<TE;>;
//  // Stack: 3, Locals: 1
//  public static java.util.Set newSetFromMap(java.util.Map arg0);
//    0  new java.util.Collections$SetFromMap [238]
//    3  dup
//    4  aload_0 [arg0]
//    5  invokespecial java.util.Collections$SetFromMap(java.util.Map) [578]
//    8  areturn
//
//
//  // Method descriptor #414 (Ljava/util/Deque;)Ljava/util/Queue;
//  // Signature: <T:Ljava/lang/Object;>(Ljava/util/Deque<TT;>;)Ljava/util/Queue<TT;>;
//  // Stack: 3, Locals: 1
//  public static java.util.Queue asLifoQueue(java.util.Deque arg0);
//    0  new java.util.Collections$AsLIFOQueue [218]
//    3  dup
//    4  aload_0 [arg0]
//    5  invokespecial java.util.Collections$AsLIFOQueue(java.util.Deque) [562]
//    8  areturn
//
//
//  // Method descriptor #6 ()V
//  // Stack: 3, Locals: 0
//  static {};
//     0  new java.util.Collections$EmptySet [235]
//     3  dup
//     4  aconst_null
//     5  invokespecial java.util.Collections$EmptySet(java.util.Collections$1) [576]
//     8  putstatic java.util.Collections.EMPTY_SET : java.util.Set [526]
//    11  new java.util.Collections$EmptyList [232]
//    14  dup
//    15  aconst_null
//    16  invokespecial java.util.Collections$EmptyList(java.util.Collections$1) [574]
//    19  putstatic java.util.Collections.EMPTY_LIST : java.util.List [523]
//    22  new java.util.Collections$EmptyMap [234]
//    25  dup
//    26  aconst_null
//    27  invokespecial java.util.Collections$EmptyMap(java.util.Collections$1) [575]
//    30  putstatic java.util.Collections.EMPTY_MAP : java.util.Map [524]
//    33  return
//
//  Inner classes:
//    [inner class info: #215 java/util/Collections$1, outer class info: #0
//     inner name: #0, accessflags: 8 static],
//    [inner class info: #216 java/util/Collections$2, outer class info: #0
//     inner name: #0, accessflags: 8 static],
//    [inner class info: #217 java/util/Collections$3, outer class info: #0
//     inner name: #0, accessflags: 8 static],
//    [inner class info: #218 java/util/Collections$AsLIFOQueue, outer class info: #214 java/util/Collections
//     inner name: #630 AsLIFOQueue, accessflags: 8 static],
//    [inner class info: #219 java/util/Collections$CheckedCollection, outer class info: #214 java/util/Collections
//     inner name: #631 CheckedCollection, accessflags: 8 static],
//    [inner class info: #220 java/util/Collections$CheckedList, outer class info: #214 java/util/Collections
//     inner name: #632 CheckedList, accessflags: 8 static],
//    [inner class info: #221 java/util/Collections$CheckedMap, outer class info: #214 java/util/Collections
//     inner name: #633 CheckedMap, accessflags: 10 private static],
//    [inner class info: #222 java/util/Collections$CheckedNavigableMap, outer class info: #214 java/util/Collections
//     inner name: #634 CheckedNavigableMap, accessflags: 8 static],
//    [inner class info: #223 java/util/Collections$CheckedNavigableSet, outer class info: #214 java/util/Collections
//     inner name: #635 CheckedNavigableSet, accessflags: 8 static],
//    [inner class info: #224 java/util/Collections$CheckedQueue, outer class info: #214 java/util/Collections
//     inner name: #636 CheckedQueue, accessflags: 8 static],
//    [inner class info: #225 java/util/Collections$CheckedRandomAccessList, outer class info: #214 java/util/Collections
//     inner name: #637 CheckedRandomAccessList, accessflags: 8 static],
//    [inner class info: #226 java/util/Collections$CheckedSet, outer class info: #214 java/util/Collections
//     inner name: #638 CheckedSet, accessflags: 8 static],
//    [inner class info: #227 java/util/Collections$CheckedSortedMap, outer class info: #214 java/util/Collections
//     inner name: #639 CheckedSortedMap, accessflags: 8 static],
//    [inner class info: #228 java/util/Collections$CheckedSortedSet, outer class info: #214 java/util/Collections
//     inner name: #640 CheckedSortedSet, accessflags: 8 static],
//    [inner class info: #229 java/util/Collections$CopiesList, outer class info: #214 java/util/Collections
//     inner name: #641 CopiesList, accessflags: 10 private static],
//    [inner class info: #230 java/util/Collections$EmptyEnumeration, outer class info: #214 java/util/Collections
//     inner name: #642 EmptyEnumeration, accessflags: 10 private static],
//    [inner class info: #231 java/util/Collections$EmptyIterator, outer class info: #214 java/util/Collections
//     inner name: #643 EmptyIterator, accessflags: 10 private static],
//    [inner class info: #232 java/util/Collections$EmptyList, outer class info: #214 java/util/Collections
//     inner name: #24 EmptyList, accessflags: 10 private static],
//    [inner class info: #233 java/util/Collections$EmptyListIterator, outer class info: #214 java/util/Collections
//     inner name: #644 EmptyListIterator, accessflags: 10 private static],
//    [inner class info: #234 java/util/Collections$EmptyMap, outer class info: #214 java/util/Collections
//     inner name: #645 EmptyMap, accessflags: 10 private static],
//    [inner class info: #235 java/util/Collections$EmptySet, outer class info: #214 java/util/Collections
//     inner name: #647 EmptySet, accessflags: 10 private static],
//    [inner class info: #236 java/util/Collections$ReverseComparator, outer class info: #214 java/util/Collections
//     inner name: #648 ReverseComparator, accessflags: 10 private static],
//    [inner class info: #237 java/util/Collections$ReverseComparator2, outer class info: #214 java/util/Collections
//     inner name: #649 ReverseComparator2, accessflags: 10 private static],
//    [inner class info: #238 java/util/Collections$SetFromMap, outer class info: #214 java/util/Collections
//     inner name: #650 SetFromMap, accessflags: 10 private static],
//    [inner class info: #239 java/util/Collections$SingletonList, outer class info: #214 java/util/Collections
//     inner name: #651 SingletonList, accessflags: 10 private static],
//    [inner class info: #240 java/util/Collections$SingletonMap, outer class info: #214 java/util/Collections
//     inner name: #652 SingletonMap, accessflags: 10 private static],
//    [inner class info: #241 java/util/Collections$SingletonSet, outer class info: #214 java/util/Collections
//     inner name: #653 SingletonSet, accessflags: 10 private static],
//    [inner class info: #242 java/util/Collections$SynchronizedCollection, outer class info: #214 java/util/Collections
//     inner name: #654 SynchronizedCollection, accessflags: 8 static],
//    [inner class info: #243 java/util/Collections$SynchronizedList, outer class info: #214 java/util/Collections
//     inner name: #655 SynchronizedList, accessflags: 8 static],
//    [inner class info: #244 java/util/Collections$SynchronizedMap, outer class info: #214 java/util/Collections
//     inner name: #656 SynchronizedMap, accessflags: 10 private static],
//    [inner class info: #245 java/util/Collections$SynchronizedNavigableMap, outer class info: #214 java/util/Collections
//     inner name: #657 SynchronizedNavigableMap, accessflags: 8 static],
//    [inner class info: #246 java/util/Collections$SynchronizedNavigableSet, outer class info: #214 java/util/Collections
//     inner name: #658 SynchronizedNavigableSet, accessflags: 8 static],
//    [inner class info: #247 java/util/Collections$SynchronizedRandomAccessList, outer class info: #214 java/util/Collections
//     inner name: #659 SynchronizedRandomAccessList, accessflags: 8 static],
//    [inner class info: #248 java/util/Collections$SynchronizedSet, outer class info: #214 java/util/Collections
//     inner name: #660 SynchronizedSet, accessflags: 8 static],
//    [inner class info: #249 java/util/Collections$SynchronizedSortedMap, outer class info: #214 java/util/Collections
//     inner name: #661 SynchronizedSortedMap, accessflags: 8 static],
//    [inner class info: #250 java/util/Collections$SynchronizedSortedSet, outer class info: #214 java/util/Collections
//     inner name: #662 SynchronizedSortedSet, accessflags: 8 static],
//    [inner class info: #251 java/util/Collections$UnmodifiableCollection, outer class info: #214 java/util/Collections
//     inner name: #663 UnmodifiableCollection, accessflags: 8 static],
//    [inner class info: #252 java/util/Collections$UnmodifiableList, outer class info: #214 java/util/Collections
//     inner name: #664 UnmodifiableList, accessflags: 8 static],
//    [inner class info: #253 java/util/Collections$UnmodifiableMap, outer class info: #214 java/util/Collections
//     inner name: #665 UnmodifiableMap, accessflags: 10 private static],
//    [inner class info: #254 java/util/Collections$UnmodifiableNavigableMap, outer class info: #214 java/util/Collections
//     inner name: #666 UnmodifiableNavigableMap, accessflags: 8 static],
//    [inner class info: #256 java/util/Collections$UnmodifiableNavigableSet, outer class info: #214 java/util/Collections
//     inner name: #667 UnmodifiableNavigableSet, accessflags: 8 static],
//    [inner class info: #257 java/util/Collections$UnmodifiableRandomAccessList, outer class info: #214 java/util/Collections
//     inner name: #668 UnmodifiableRandomAccessList, accessflags: 8 static],
//    [inner class info: #258 java/util/Collections$UnmodifiableSet, outer class info: #214 java/util/Collections
//     inner name: #669 UnmodifiableSet, accessflags: 8 static],
//    [inner class info: #259 java/util/Collections$UnmodifiableSortedMap, outer class info: #214 java/util/Collections
//     inner name: #670 UnmodifiableSortedMap, accessflags: 8 static],
//    [inner class info: #260 java/util/Collections$UnmodifiableSortedSet, outer class info: #214 java/util/Collections
//     inner name: #671 UnmodifiableSortedSet, accessflags: 8 static],
//    [inner class info: #255 java/util/Collections$UnmodifiableNavigableMap$EmptyNavigableMap, outer class info: #254 java/util/Collections$UnmodifiableNavigableMap
//     inner name: #646 EmptyNavigableMap, accessflags: 10 private static]
//}