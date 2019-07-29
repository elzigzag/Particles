package com.particles.android;

import static android.opengl.GLES20.GL_TRIANGLE_FAN;
import static android.opengl.GLES20.glDrawArrays;
import com.particles.android.ObjectBuilder.GeneratedData;
import com.particles.android.ObjectBuilder.DrawCommand;
import java.util.List;


public class SquareObject {
    private static final int POSITION_COMPONENT_COUNT = 3;
    private final VertexArray vertexArray;
    private final List<DrawCommand> drawList;


    public SquareObject(){
        GeneratedData generatedData = ObjectBuilder.createSquare(0f, 0f, 0f, 1f);
        vertexArray = new VertexArray(generatedData.vertexData);
        drawList = generatedData.drawList;
    }

    public SquareObject(float t){
        GeneratedData generatedData = ObjectBuilder.createSquare(0f, 0f, 0f, t);
        vertexArray = new VertexArray(generatedData.vertexData);
        drawList = generatedData.drawList;
    }

    public void bindData(ColorShaderProgram colorProgram){
        vertexArray.setVertexAttribPointer(0, colorProgram.getPositionAttributeLocation(),
                POSITION_COMPONENT_COUNT, 0);

    }

    public void draw(){
        for (DrawCommand drawCommand : drawList){
            drawCommand.draw();
        }
    }
}
