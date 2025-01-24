public class LevelLoop {
    
    static double apress = 0.0;
   static  double bpress = 0.0;
   static int repeat = 0;

    public static int looplevel(){
    
        
        
        
        if(Controller.one == true){
            apress += (1/56.0);
            if(apress >= 1){
             
                apress = 0.0;
                repeat = 1;
            }
        }
        if(Controller.two == true){
            bpress += (1/56.0);
            if(bpress >= 1){
              
                bpress = 0.0;
                repeat = 2;
            }
        }

       
            return repeat;
        
        
      
    }
}
