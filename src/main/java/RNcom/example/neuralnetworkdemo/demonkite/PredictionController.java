package RNcom.example.neuralnetworkdemo.demonkite;

import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.deeplearning4j.util.ModelSerializer;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PredictionController {
	
	private MultiLayerNetwork model;

    public PredictionController() throws Exception {
        this.model = ModelSerializer.restoreMultiLayerNetwork("or_model.zip");
    }

  
    @PostMapping("/predict")
    public String predict(@RequestBody InputData inputData) {
        double[] inputs = inputData.getInputs();  
        
        // no exception global
       /* if (inputs == null || inputs.length == 0) {
            return "Error: Los datos de entrada son incorrectos.";
        } */
        
        // Verificación básica de los datos de entrada con exception global
        if (inputs == null || inputs.length == 0) {
            throw new IllegalArgumentException("Los datos de entrada no pueden ser nulos ni vacíos.");
        }
       
        /*
        INDArray input = Nd4j.create(new double[][]{inputs});
        INDArray prediction = model.output(input);
        
        return "Predicción: " + prediction.toString();
        */
        
     // Crear un INDArray con los datos de entrada
        INDArray input = Nd4j.create(new double[][]{inputs});
        
        // Hacer la predicción con el modelo
        INDArray prediction = model.output(input);

        // Obtener el valor de la predicción (predicción con decimales)
        double predValue = prediction.getDouble(0);  // Tomamos el primer valor de la predicción
        
        // Usamos String.format para redondear a 4 decimales
        String formattedPrediction = String.format("%.4f", predValue);
        
        // Lógica para determinar el valor final de la predicción (mayor a 0.5 es 1, menor o igual es 0)
        int result = (predValue > 0.5) ? 1 : 0;  

        // Devuelves ambos resultados: uno con el valor decimal y otro con el 0 o 1
        return "Predicción (decimal): " + formattedPrediction + "\nPredicción (0 o 1): " + result;
        
    }

}


/*  @PostMapping("/predict")
public String predict(@RequestBody double[] inputs) {
   
    INDArray inputData = Nd4j.create(new double[][]{inputs});
    
    INDArray prediction = model.output(inputData);
    
    return "Predicción: " + prediction.toString();
}*/