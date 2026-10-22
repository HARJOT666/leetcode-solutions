
class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        List<String> list = new ArrayList<>();
        for(int i=0;i<equations.size();i++){
            for(int j=0;j<2;j++){
                if(!list.contains(equations.get(i).get(j))){
                    list.add(equations.get(i).get(j));
                }
            }
        }
        double[] arr = new double[queries.size()];

        List<List<String>> newEquations = new ArrayList<>();
        List<Double> newValues = new ArrayList<>();

        // Add original equations and their reverse
        for(int i=0;i<equations.size();i++){

            newEquations.add(equations.get(i));
            newValues.add(values[i]);

            // c/a = 1 / (a/b * b/c)
            List<String> reverse = Arrays.asList(
                equations.get(i).get(1),
                equations.get(i).get(0)
            );

            if(!newEquations.contains(reverse)){
                newEquations.add(reverse);
                newValues.add(1.0 / values[i]);
            }
        }

        // Generate all possible combinations
        boolean changed = true;

        while(changed){
            changed = false;

            int n = newEquations.size();

            for(int k=0;k<n;k++){
                for(int l=0;l<n;l++){

                    // a/b * b/c = a/c
                    if(newEquations.get(k).get(1).equals(
                       newEquations.get(l).get(0))){

                        List<String> temp = Arrays.asList(
                            newEquations.get(k).get(0),
                            newEquations.get(l).get(1)
                        );

                        if(!newEquations.contains(temp)){
                            newEquations.add(temp);

                            newValues.add(
                                newValues.get(k) * newValues.get(l)
                            );

                            changed = true;
                        }
                    }
                }
            }
        }

        // Check all queries
        for(int i=0;i<queries.size();i++){

            arr[i] = -1.0;

            //base condition is to return -1 of that string is not present in the eqns
            if(!list.contains(queries.get(i).get(0)) ||
               !list.contains(queries.get(i).get(1))){
                arr[i] = -1.0;
            }

            //if numerator and denominator are smae simply give 1
            else if(queries.get(i).get(0).equals(
                    queries.get(i).get(1))){
                arr[i] = 1.0;
            }

            else{
                int index = newEquations.indexOf(queries.get(i));

                if(index != -1){
                    arr[i] = newValues.get(index);
                }
            }
        }

        return arr;
    }
}
