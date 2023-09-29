public class IndeksertListe <E> extends Lenkeliste <E> {

    
    //hent verdi i en gitt posisjon
    public E hent(int pos) throws UgyldigListeindeks{
        
        if (stoerrelse() == 0){
            throw new UgyldigListeindeks(pos);
        }
          
        if (pos > stoerrelse() - 1 || pos < 0){
        throw new UgyldigListeindeks(pos);
        }

        int teller = 0;
        Node midlertidig = foerste;
        while (teller < pos) {
            midlertidig = midlertidig.neste;
            teller++;
        }
        return midlertidig.verdi;

    }


    //legg til i en gitt posisjon
    public void leggTil(int pos, E x) throws UgyldigListeindeks{
        

        if (stoerrelse() == 0 && pos > 0){
            throw new UgyldigListeindeks(pos);
          }

        if (pos < 0){
            throw new UgyldigListeindeks(pos);
        }
        //Node midlertidig peker på foerste
        Node midlertidig = foerste; 
        //oppretter Node-objekt
        Node nyNode = new Node(x);

        //hvis listen er tom
        if (this.foerste == null) { 
            this.foerste = nyNode;
            this.siste = nyNode;
            return;
                
               
            }
        //legger til først i lenkelisten
        if (pos == 0) { 
                
            foerste = nyNode;
            foerste.neste = midlertidig;
            midlertidig.forrige = nyNode;
            // siste = midlertidig;    
            return;
                
            }
        
        //legger til sist i lenkelisten
        if (pos > stoerrelse()-1) { 

            super.leggTil(nyNode.verdi); 
            // siste.neste = nyNode; //en måte å legge til sist på
            // nyNode.forrige = siste;
            // siste = nyNode;

            // while(midlertidig.neste != null) { //en annen måte å legge sist på
            //     midlertidig = midlertidig.neste;
            // }
            // midlertidig.neste = nyNode;
            // nyNode.forrige = midlertidig;
            // siste = nyNode;
            return; 

        }
       
        for (int i = 0; i < pos; i++) {
            midlertidig = midlertidig.neste;
            
        }
        //legger til imellom to Node-objeketer
        nyNode.neste = midlertidig;
        nyNode.forrige = midlertidig.forrige;
        midlertidig.forrige.neste = nyNode;
        midlertidig.forrige = nyNode;
        return;
        

        }
        //erstatter Node.verdi i en gitt posisjon
        public void sett(int pos, E x) throws UgyldigListeindeks{
            
            if (stoerrelse() == 0){
              throw new UgyldigListeindeks(pos);
            }
            
            if (pos > stoerrelse() - 1 || pos < 0){
              throw new UgyldigListeindeks(pos);
            }
            
            int teller = 0;
            Node midlertidig  = foerste;
            //mens teller er mindre enn gitt posisjon
            while (teller < pos){
            //går videre til neste i lenkelisten
              midlertidig = midlertidig.neste;
              teller++;
            }
            //når man har kommet frem til posisjonen, har gått ut av while-løkken
            //da erstattes verdien til x
            midlertidig.verdi = x;     
        
            
        }
        //fjern i en gitt posisjon
        public E fjern(int pos) throws UgyldigListeindeks{


            if (stoerrelse() == 0){
                throw new UgyldigListeindeks(pos);
              }
    
            if (pos > stoerrelse()-1 || pos < 0){
                throw new UgyldigListeindeks(pos);
            }
            int teller = 0;
            Node midlertidig = foerste;
            //itererer gjennom lenkelisten til den gitte posisjonen
            while(teller != pos) {
                midlertidig = midlertidig.neste;
                teller++;
            }

            if (stoerrelse() == 1) { 
                
                this.foerste = null;
                this.siste = null;
                return midlertidig.verdi;        
                   
            }

            //fjern foerste i lenkelisten
            if (pos == 0) { 
            
                return super.fjern();

            }
            //fjerner siste
            if (pos == stoerrelse()-1) { 
                
                
                siste = midlertidig.forrige;
                midlertidig.forrige.neste = null;  
                return midlertidig.verdi;
   
            }

                //fjerner i midten
                midlertidig.forrige.neste = midlertidig.neste;
                midlertidig.neste.forrige = midlertidig.forrige;
                return midlertidig.verdi;
  

        
}
}
