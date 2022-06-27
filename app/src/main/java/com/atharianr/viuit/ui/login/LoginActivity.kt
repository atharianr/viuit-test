package com.atharianr.viuit.ui.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.atharianr.viuit.data.source.remote.network.login.LoginRequest
import com.atharianr.viuit.data.source.remote.response.vo.StatusResponse
import com.atharianr.viuit.databinding.ActivityLoginBinding
import com.atharianr.viuit.ui.list.ListActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : AppCompatActivity() {

    private val loginViewModel: LoginViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            btnLogin.setOnClickListener {
                val loginRequest =
                    LoginRequest(etUsername.text.toString(), etPassword.text.toString())

                loginViewModel.login(loginRequest).observe(this@LoginActivity) {
                    when (it.status) {
                        StatusResponse.SUCCESS -> {
                            if (it.body.rc == "00") {
                                val intent = Intent(this@LoginActivity, ListActivity::class.java)
                                startActivity(intent)
                                finish()

                                Toast.makeText(
                                    this@LoginActivity,
                                    it.body.rd,
                                    Toast.LENGTH_SHORT
                                ).show()
                            } else {
                                Toast.makeText(
                                    this@LoginActivity,
                                    it.body.rd,
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }

                        StatusResponse.ERROR -> {
                            Toast.makeText(
                                this@LoginActivity,
                                "Terjadi kesalahan, mohon ulangi.",
                                Toast.LENGTH_SHORT
                            ).show()
                        }

                        else -> {}
                    }
                }
            }
        }
    }
}