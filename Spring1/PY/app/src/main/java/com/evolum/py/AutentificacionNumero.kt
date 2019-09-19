package com.evolum.py

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.android.gms.tasks.Task
import com.google.firebase.FirebaseException
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider
import kotlinx.android.synthetic.main.activity_autentificacion_numero.*
import java.util.concurrent.TimeUnit

class AutentificacionNumero : AppCompatActivity() {

    lateinit var mCallbacks: PhoneAuthProvider.OnVerificationStateChangedCallbacks
    lateinit var mAuth: FirebaseAuth
    var verificationId = ""
    var estado = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_autentificacion_numero)
        mAuth = FirebaseAuth.getInstance()
        button.setOnClickListener{
            if (estado == 0){
                //Toast.makeText(this,"verify()",Toast.LENGTH_LONG).show()
                verify ()
                estado = 3
                editText.setText(null)
                editText.setHint("Codigo de confirmacion")
                button.setText("Ingresar")
            }
            else{
                //Toast.makeText(this,"authenticate()",Toast.LENGTH_LONG).show()
                authenticate()
                estado = estado - 1
                if (estado == 0){
                    editText.setText(null)
                    editText.setHint("Numero Celular")
                    button.setText("Enviar Codigo")
                }
            }
        }
    }


    private fun verificationCallbacks () {
        mCallbacks = object: PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            override fun onVerificationCompleted(credential: PhoneAuthCredential) {
                signIn(credential)
            }

            override fun onVerificationFailed(p0: FirebaseException?) {
                toast("Error")
                estado = 0
                editText.setText(null)
                editText.setHint("Numero Celular")
                button.setText("Enviar Codigo")
            }

            override fun onCodeSent(verfication: String?, p1: PhoneAuthProvider.ForceResendingToken?) {
                super.onCodeSent(verfication, p1)
                verificationId = verfication.toString()
            }

        }
    }

    private fun verify () {

        verificationCallbacks()

        val telMov = "+51" + editText.text.toString()

        PhoneAuthProvider.getInstance().verifyPhoneNumber(
            telMov,
            60,
            TimeUnit.SECONDS,
            this,
            mCallbacks
        )
    }

    private fun signIn (credential: PhoneAuthCredential) {
        mAuth.signInWithCredential(credential)
            .addOnCompleteListener {
                    task: Task<AuthResult> ->
                if (task.isSuccessful) {
                    toast("Ingresaste")
                    startActivity(Intent(this, MainActivity::class.java))
                }
            }
    }

    private fun authenticate () {

        val confirmacion = editText.text.toString()

        val credential: PhoneAuthCredential = PhoneAuthProvider.getCredential(verificationId, confirmacion)

        signIn(credential)

    }

    private fun toast (msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }
}
