/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estrudoestruturadados.Vetores;

/**
 *
 * @author kim
 * @param <T>
 */
public class Generico <T>{
    
    private T[ ] obj;
    private int tamanho;
    
    public Generico(int capacidade){
        
        this.obj = (T[]) new Object[capacidade];
        this.tamanho =0;
    }

   
    public void aumentarCapacidade(){
        
        if(this.tamanho == this.obj.length){
            T[ ] aumentaVetor = (T[ ]) new Object[this.obj.length * 2];
            
            for(int i = 0; i < this.obj.length; i++){
                aumentaVetor[ i ] = obj[ i ];
            }
            
            obj = aumentaVetor;
        }
        
    }
    public void addIni(T o){
        aumentarCapacidade();   //chama o método aumenta capacidade em caso do vetor estiver cheio
        for(int i = 0; i < this.obj.length; i ++){
              if(this.obj[ i ] == null){
                  this.obj[ i ] = o;
                  break;
              }
        }
        this.tamanho++;
    }
    public boolean addPos(int pos, T o){
        aumentarCapacidade();    // chama o método aumentar capacidade
        if((pos >= 0 && pos < this.tamanho)){
              throw  new IllegalArgumentException("Posição inválida!");
        }
        
        for(int i = this.tamanho -1; i >= pos; i--){
            this.obj[ i + 1] = (T) this.obj[ i ];
        }
        this.obj[pos] = o;
        this.tamanho++;
        return true;
    }
    public String toString(){
        
        StringBuilder str = new StringBuilder();
        str.append(" [ ");
        for(int i = 0; i < this.tamanho -1; i++){
            str.append(this.obj[ i ]);
            str.append(" , ");
        }
        if(this.tamanho > 0){
            
            str.append(this.obj[this.tamanho-1]);
        }
        str.append(" ] ");
        return str.toString();
        
    }
    public Object  encontrarObj(int pos, T o){
        
        if( !(pos >= 0 && pos < this.tamanho)){
            throw  new IllegalArgumentException();
        }
        for(int i = 0; i < this.obj.length; i++){
            this.obj[ i + 1] =  o;
            return obj;
        }
        return null;
        
    } 
    public void removeObjQualquerPosicao(int pos){
        
        if(!(pos >= 0 && pos < this.tamanho)){
               throw  new IllegalArgumentException("Posição inválida!");
        }
        for(int i = pos; i < this.tamanho; i++){
            this.obj[ i ] = this.obj[ i + 1];
            
            this.tamanho--;
        }
    }
    public void teste(){
        Generico<Integer> vet = new Generico<>(10);
         
       vet.addIni(35);
        vet.addPos(1, 80);
        vet.addPos(2, 55);
          vet.addPos(3, 582);
        
        System.out.println(vet);
        
    }
}
