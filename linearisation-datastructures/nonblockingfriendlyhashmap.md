# Concept
// todo: improve
Ideas of hash map applies
- Maintain 2 `Table` (table1 and table2)
- table1 as primary and table2 as secondary when rehashing
- `Table` contains `final HashEntry[]`
- During rehasing (occupancy is greater than 0.75), each entry in table1 is copied
over to table2 one by one
- once a row in table1 is rehashed to table2, that row is replaced with dummy object
- once all rows in table1 is rehased table1 reference is set to table2



# Ambiguities
## clear() method
// todo: improve and confirm
```
    @Override
    public void clear() {
        this.stopMaintenance();
        this.structMods = 0;
        HashEntry<K, V>[] tab = table1.table;
        for (int i = 0; i < tab.length; i++) {
            tab[i] = null;
        }
        this.startMaintenance();
    }
```
- tab is a `final HashEntry[]` in `Table`
- final applies to the reference
- when we do `tab[i] = null` through different threads, is there a chance that it will never be set to null?


## size() method
```
    @Override
    public int size() {
        HashEntry<K, V>[] tab = table1.table;
        HashEntry<K, V> next;
        int count = 0;

        for (int i = 0; i < tab.length; i++) {
            next = tab[i];
            while (next != null) {
                count++;
                next = next.next;
            }
        }
        return count;
    }
```

Say for example case 1
// todo: improve and confirm
- table1 is being migrated to table2 but table1 reference have not being changed to table2
- table1 `HashEntry[]` contains dummy
- size will count entries in table1 that are all dummy object.
- ????


Say for example case 2
- table1 size is 4, table2 size is 8
- entry with key (and hash) 2 goes into index 2 in table1
- entry with key (and hash) 6 goes into index 2 of table1
- entry with key (and hash) 2 would go into index 2 in table2
- entry with key (and hash) 6 would go into index 6 in table2
- say now table1 entry at index 2 is written as dummy
- say now table2 entry at index 2 is written as entry with key (and hash) 2 
- say now table2 entry at index 2 is written as entry with key (and hash) 6
- if we count the size now, it will just take into account table1 and since it is no a dummy
object, it's size will be 1. In actual fact it should be 2




## rehashLevel() method
// todo: work this out



