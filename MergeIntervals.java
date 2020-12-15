import java.util.*;

class Interval implements Comparable<Interval> {
    int start;
    int end;
    public Interval(int start, int end){
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Interval o) {
        return 0;
    }
}



class MergeIntervals {


    public static List<Interval> merge(List<Interval> intervals){
        //case: interval 1 or 0
        if(intervals.size() < 2)
            return intervals;

        //output
        List<Interval> mergedList = new LinkedList<Interval>();

        //sort list
        Collections.sort(intervals, (a,b)-> Integer.compare(a.start,b.start));

        Iterator<Interval> itr= intervals.iterator();
        Interval ref = itr.next();
        int start = ref.start;
        int end = ref.end;

        while(itr.hasNext()){
            Interval current = itr.next();
            //overlap
            if(current.start <= end){
                end = Math.max(end, current.end);
            }else { //non-overlap
                mergedList.add(new Interval(start, end));
                start = current.start;
                end = current.end;
            }
        }
        //last interval (ref point start and end)
        mergedList.add(new Interval(start, end));
        return mergedList;
    }

    public static void main(String[] args) {
        List<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 5));
        input.add(new Interval(7, 9));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(6, 7));
        input.add(new Interval(2, 4));
        input.add(new Interval(5, 9));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 6));
        input.add(new Interval(3, 5));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();
    }

}
