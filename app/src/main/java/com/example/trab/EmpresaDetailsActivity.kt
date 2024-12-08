package com.example.trab

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.trab.databinding.ActivityEmpresaDetailsBinding

class EmpresaDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEmpresaDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEmpresaDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Recupera os dados da Intent
        val nome = intent.getStringExtra("nome")
        val descricao = intent.getStringExtra("descricao")
        val cidade = intent.getStringExtra("cidade")
        val numAlunos = intent.getIntExtra("num_alunos", 0)
        val numVagas = intent.getIntExtra("num_vagas", 0)

        // Configura os TextViews com os dados
        binding.empresaNome.text = nome
        binding.empresaDescricao.text = descricao
        binding.empresaCidade.text = "Cidade: $cidade"
        binding.empresaNumAlunos.text = "Alunos que estagiaram: $numAlunos"
        binding.empresaNumVagas.text = "Vagas disponíveis: $numVagas"

        // Configurar botão de adicionar aos favoritos
        binding.btnFavoritar.setOnClickListener {
            Toast.makeText(this, "$nome adicionada aos favoritos!", Toast.LENGTH_SHORT).show()
        }

        // Configuração para comentários (simples Toast de exemplo)
        binding.btnEnviarComentario.setOnClickListener {
            val comentario = binding.inputComentario.text.toString()
            if (comentario.isNotEmpty()) {
                Toast.makeText(this, "Comentário enviado: $comentario", Toast.LENGTH_SHORT).show()
                binding.inputComentario.text.clear()
            } else {
                Toast.makeText(this, "Escreva um comentário antes de enviar", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
