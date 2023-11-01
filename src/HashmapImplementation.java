import java.util.ArrayList;
import java.util.LinkedList;


public class HashmapImplementation {
    private final int keySpace;
    private final ArrayList<Bucket> buckets;

    private class HashMapEntry {
        public String key;
        public Object value;

        public HashMapEntry(String key, Object value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "{" +
                    "key = '" + key + '\'' +
                    ", value = " + value +
                    '}';
        }
    }

    private class Bucket {
        private final LinkedList<HashMapEntry> list;
        private static int index;
        private int bucketIndex;

        public Bucket() {
            this.list = new LinkedList<>();
            this.bucketIndex = index++;
        }

        public void add(String key, Object value) {
            boolean found = false;
            for (HashMapEntry entry : this.list) {
                if (entry.key.equals(key)) {
                    entry.value = value;
                    found = true;
                    break;
                }
            }
            if (!found) {
                this.list.add(new HashMapEntry(key, value));
            }
        }

        public void delete(String key) {
            for (HashMapEntry entry : this.list) {
                if (entry.key.equals(key)) {
                    this.list.remove(entry);
                    break;
                }
            }
        }

        public Object get(String key) {
            for (HashMapEntry entry : this.list) {
                if (entry.key.equals(key)) {
                    return entry.value;
                }
            }
            return -1;
        }

        @Override
        public String toString() {
            return "\nBucket" + this.bucketIndex +  list;
        }
    }

    public HashmapImplementation() {
        this.keySpace = 10;
        this.buckets = new ArrayList<Bucket>();
        for (int i = 0; i < this.keySpace; i++) {
            this.buckets.add(new Bucket());
        }
    }

    public void put(String key, Object value) {
        this.buckets.get(hashFunction(key)).add(key, value);
    }

    public Object get(String key) {
        return this.buckets.get(hashFunction(key)).get(key);
    }

    public void remove(String key) {
        this.buckets.get(hashFunction(key)).delete(key);
    }

    private int hashFunction(String key) {
        int hashKey = 0;
        for (char ch : key.toCharArray()) {
            if (Character.isLetter(ch)) {
                hashKey += (int) (Character.toLowerCase(ch) - 'a');
            }
        }
        hashKey %= this.keySpace;
        return hashKey;
    }

    @Override
    public String toString() {
        return "HashMap{" +
                "keySpace = " + keySpace +
                ", hashTable = " + buckets +
                '}';
    }

    public static void main(String[] args) {
        HashmapImplementation hashmap = new HashmapImplementation();
        hashmap.put("你好", "Hi");
        hashmap.put("你好", "Yo");
        hashmap.put("他", "He");
        hashmap.put("她", "She");
        hashmap.put("我", "I");
        hashmap.put("再見", "See you");
        hashmap.put("早餐", "Breakfast");
        hashmap.put("午餐", "Lunch");
        hashmap.put("晚餐", "Dinner");
        hashmap.put("狗", "Dog");
        hashmap.put("貓", "Cat");
        hashmap.put("兔子", "Rabbit");
        hashmap.put("蛇", "Snake");
        hashmap.put("馬", "Horse");
        hashmap.put("豬", "Pig");
        hashmap.put("牛", "Cow");
        hashmap.put("鼠", "Mice");
        hashmap.put("狗", "Doggy");
        hashmap.put("龍", "Dragon");
        hashmap.put("雞", "Chicken");
        hashmap.put("羊", "Goat");

        hashmap.remove("羊");
        hashmap.remove("晚餐");
        System.out.println(hashmap.get("狗"));
        System.out.println(hashmap.get("貓"));
        System.out.println(hashmap.get("晚餐"));

        System.out.println(hashmap);
    }


}
