package RNcom.example.neuralnetworkdemo.demonkite;

import org.deeplearning4j.datasets.iterator.utilty.ListDataSetIterator;
import org.deeplearning4j.nn.conf.MultiLayerConfiguration;
import org.deeplearning4j.nn.conf.NeuralNetConfiguration;
import org.deeplearning4j.nn.conf.layers.DenseLayer;
import org.deeplearning4j.nn.conf.layers.OutputLayer;
import org.deeplearning4j.optimize.listeners.ScoreIterationListener;
import org.deeplearning4j.util.ModelSerializer;

import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;

import org.nd4j.linalg.lossfunctions.LossFunctions;
import org.nd4j.linalg.activations.Activation;

import org.nd4j.linalg.dataset.DataSet;
import org.nd4j.linalg.dataset.api.iterator.DataSetIterator;
import org.nd4j.linalg.learning.config.*;

public class NeuralNetworkTrainer {

    public static void trainAndSaveModel() throws Exception {
   
        INDArray input = Nd4j.create(new double[][]{
            {0, 0},
            {0, 1},
            {1, 0},
            {1, 1}
        });
        
        INDArray output = Nd4j.create(new double[][]{
            {0},
            {1},
            {1},
            {1}
        });

        DataSet dataSet = new DataSet(input, output);
        DataSetIterator iterator = new ListDataSetIterator<>(dataSet.asList(), 4);
        
        MultiLayerConfiguration config = new NeuralNetConfiguration.Builder()
        	    .seed(123)
        	    .updater(new Sgd(0.1))
        	    .l2(0.0001)
        	    .list()
        	    .layer(0, new DenseLayer.Builder().nIn(2).nOut(3)
        	            .activation(Activation.RELU)
        	            .build())
        	    .layer(1, new OutputLayer.Builder()
        	            .nIn(3).nOut(1)
        	            .activation(Activation.SIGMOID)
        	            .lossFunction(LossFunctions.LossFunction.XENT)
        	            .build())
        	    .build();

        org.deeplearning4j.nn.multilayer.MultiLayerNetwork model = new org.deeplearning4j.nn.multilayer.MultiLayerNetwork(config);
        model.init();
        model.setListeners(new ScoreIterationListener(100)); 
        
        for (int epoch = 0; epoch < 1000; epoch++) {
            model.fit(iterator);
        }

        ModelSerializer.writeModel(model, "or_model.zip", true);
        
        INDArray outputPred = model.output(input);
        System.out.println("Predicción: " + outputPred);
    }
    
   /* public static void main(String[] args) {
        try {
         
            NeuralNetworkTrainer.trainAndSaveModel();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
}
