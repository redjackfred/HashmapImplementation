import java.util.LinkedList;
import java.util.List;

class Bucket{
    private final List<Pair<String, Integer>> bucket;

    public Bucket(){
        this.bucket = new LinkedList<Pair<String, Integer>>();
    }

    public void add(String key, int value){
        boolean found = false;
        for(Pair<String, Integer> pair : this.bucket){
            if(pair.first.equals(key)){
                pair.second = value;
                found = true;
                break;
            }
        }
        if(!found){
            this.bucket.add(new Pair<String, Integer>(key, value));
        }
    }

    public void delete(String key){
        for(Pair<String, Integer> pair : this.bucket){
            if(pair.first.equals(key)) {
                this.bucket.remove(pair);
                break;
            }
        }
    }

    public int get(String key){
        for(Pair<String, Integer> pair : this.bucket){
            if(pair.first.equals(key)) {
                return pair.second;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        return "\nBucket{" +
                "bucket=" + bucket +
                '}';
    }
}
