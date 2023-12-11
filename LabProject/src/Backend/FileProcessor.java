package Backend;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileProcessor {

    public Graph fetchFromFile(String localPath){
        File graphFile = new File(localPath);
        Graph outputGraph = new Graph();

        ArrayList<Edge> edgeList = new ArrayList<Edge>();
        ArrayList<Vertex> vertexList = new ArrayList<Vertex>();
        try{
            Scanner fileRead = new Scanner(graphFile);
            while(fileRead.hasNext()){
                String[] fetchedEdges = fileRead.next().split(",");
                int startingId = Integer.parseInt(fetchedEdges[0]);
                Vertex startingVertex = new Vertex(startingId);
                int endingId = Integer.parseInt(fetchedEdges[1]);
                Vertex endingVertex = new Vertex(endingId);
                double edgeWeight = Double.parseDouble(fetchedEdges[2]);
                int edgeId = Integer.parseInt(fetchedEdges[3]);
                Edge currentEdge = new Edge(startingVertex, endingVertex, edgeWeight,edgeId);
                edgeList.add(currentEdge);
                startingVertex.addEdge(currentEdge);
                endingVertex.addEdge(currentEdge);
                addToVertexList(vertexList, startingVertex, currentEdge);
                addToVertexList(vertexList, endingVertex, currentEdge);
            }
            for(int x = 0; x < vertexList.size(); x++){
                outputGraph.addVertex(vertexList.get(x));
            }

            return outputGraph;


        }catch(FileNotFoundException fileNotFound){
            fileNotFound.printStackTrace();
        }
        return null;
    }

    private void addToVertexList(ArrayList<Vertex> vertexList, Vertex vertex, Edge edge){
        if(!(vertexList.contains(vertex))){
            vertexList.add(vertex);
        }else{
            Vertex v = vertexList.get(vertexList.indexOf(vertex));
            v.addEdge(edge);
        }
    }

}
