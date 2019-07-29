package com.particles.android.programs;

import android.content.Context;
import android.util.Log;

import com.particles.android.R;
import static android.opengl.GLES20.*;

public class ParticleShaderProgram extends ShaderProgram {
    //Uniform Locations
    private final int uMatrixLocation;
    private final int uTimeLocation;
    //Attribute Location
    private final int aPositionLocation;
    private final int aColorLocation;
    private final int aDirectionVectorLocation;
    private final int aParticleStartTimeLocation;
    private final int uTextureUnitLocation;

    public ParticleShaderProgram(Context context) {
        super(context, R.raw.particle_vertex_shader, R.raw.particle_fragment_shader);
        //Retrieve uniform locations for the shader program.
        this.uMatrixLocation = glGetUniformLocation(
                super.program, super.U_MATRIX
        );
        this.uTimeLocation = glGetUniformLocation(
                super.program, super.U_TIME
        );
        //Retrieve attribute locations for the shader program.
        this.aPositionLocation = glGetAttribLocation(
                super.program, super.A_POSITION
        );
        this.aColorLocation = glGetAttribLocation(
                super.program, super.A_COLOR
        );
        this.aDirectionVectorLocation = glGetAttribLocation(
                super.program, super.A_DIRECTION_VECTOR
        );
        this.aParticleStartTimeLocation = glGetAttribLocation(
                super.program, super.A_PARTICLE_START_TIME
        );
        this.uTextureUnitLocation = glGetUniformLocation(
                program, U_TEXTURRE_UNIT
        );
    }

    //>TestCode
    public void verifyIdForAttibsAndUniforms(){
        Log.i(" -> "," TEST: verifyIdForAttribsAndUniforms() \n ");
        Log.i(" -> "," " +
                " colorAttributeLocation: " + getaColorLocation() + "\n" +
                " uMatrixLocation: " + getuMatrixLocation() + " \n " +
                " uTimeLocation: " + getuTimeLocation() + "\n" +
                " aPositionLocation:" + getaPositionLocation() + "\n" +
                " aDirectionVectorLocation: " + getaDirectionVectorLocation() + "\n" +
                " aParticleStartTimeLocation: " + getaParticleStartTimeLocation() + "\n" +
                " uTextureUnitLocation: " + getuTextureUnitLocation() + "\n");
    }
    //<TestCode
    public int getuMatrixLocation(){
        return uMatrixLocation;
    }

    public int getuTimeLocation() {
        return uTimeLocation;
    }

    public int getaPositionLocation() {
        return aPositionLocation;
    }

    public int getaDirectionVectorLocation() {
        return aDirectionVectorLocation;
    }

    public int getaParticleStartTimeLocation() {
        return aParticleStartTimeLocation;
    }

    public int getuTextureUnitLocation() {
        return uTextureUnitLocation;
    }

    public void setUniforms(float matrix[], float elapsedTime, int textureId){
        glUniformMatrix4fv(uMatrixLocation, 1, false, matrix, 0);
        glUniform1f(uTimeLocation, elapsedTime);
        glActiveTexture(GL_TEXTURE0);
        glBindTexture(GL_TEXTURE_2D, textureId);
        glUniform1i(uTextureUnitLocation, 0);
    }

    public int getPositionAttributeLocation() {
        return aPositionLocation;
    }
    public int getaColorLocation() {
        return aColorLocation;
    }
    public int getDirectionVectorAttributeLocation() {
        return aDirectionVectorLocation;
    }
    public int getParticleStartTimeAttributeLocation() {
        return aParticleStartTimeLocation;
    }
}
