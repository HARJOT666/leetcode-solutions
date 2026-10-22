
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        //if there is a common email then we merge the list and remove the repeaing element simple
        List<List<String>> ans = new ArrayList<>();
        boolean[] used = new boolean[accounts.size()];

        for(int i=0;i<accounts.size();i++){
            if(used[i]){
                continue;
            }

            List<String> list = new ArrayList<>(accounts.get(i));
            Set<String> emails = new HashSet<>(list.subList(1,list.size()));

            boolean flag = true;

            while(flag){
                flag = false;

                for(int j=i+1;j<accounts.size();j++){
                    if(used[j]){
                        continue;
                    }

                    List<String> temp = accounts.get(j);

                    //we start with 1 because we dont care of name is common or not
                    //if any element common between list and temp except for name then add it
                    for(int k=1;k<temp.size();k++){

                        if(emails.contains(temp.get(k))){

                            //add it to the answere list the combined list
                            for(int l=1;l<temp.size();l++){
                                if(emails.add(temp.get(l))){
                                    list.add(temp.get(l));
                                }
                            }

                            used[j] = true;
                            flag = true;
                            break;
                        }
                    }
                }
            }

            used[i] = true;

            //sort emails without sorting the name
            Set<String> set = new TreeSet<>(emails);

            List<String> result = new ArrayList<>();
            result.add(list.get(0));
            result.addAll(set);

            ans.add(result);
        }

        return ans;
    }
}
