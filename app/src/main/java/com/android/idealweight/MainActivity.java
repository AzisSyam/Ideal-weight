package com.android.idealweight;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
	String nama, usia, tinggiBadan, beratBadan;
	EditText inputNama, inputUsia, inputTinggiBadan, inputBeratBadan;
	TextView outputNama, outputUsia, outputTinggiBadan, outputBeratBadan, outputBeratIdeal,outputStatusIdeal;
	Button tombolHitung;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		inputNama = findViewById(R.id.input_nama);
		inputUsia = findViewById(R.id.input_usia);
		inputTinggiBadan = findViewById(R.id.input_tinggi_badan);
		inputBeratBadan = findViewById(R.id.input_berat_badan);
		tombolHitung = findViewById(R.id.tombol_hitung);

		outputNama = findViewById(R.id.isi_nama);
		outputUsia = findViewById(R.id.isi_usia);
		outputTinggiBadan = findViewById(R.id.isi_tinggi_badan);
		outputBeratBadan = findViewById(R.id.isi_berat_badan);
		outputBeratIdeal = findViewById(R.id.output_berat_ideal);
		outputStatusIdeal = findViewById(R.id.isi_status_ideal);

		tombolHitung.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				nama = inputNama.getText().toString();
				usia = inputUsia.getText().toString();
				tinggiBadan = inputTinggiBadan.getText().toString();
				beratBadan = inputBeratBadan.getText().toString();

				if (nama.isEmpty()) {
					inputNama.setError("Nama harus terisi!");
				} else if (usia.isEmpty()) {
					inputUsia.setError("Usia harus terisi!");
				} else if (tinggiBadan.isEmpty()) {
					inputTinggiBadan.setError("Tinggi harus terisi!");
				} else if (beratBadan.isEmpty()) {
					inputBeratBadan.setError("Berat harus terisi!");
				} else {
					double valueTinggiBadan = Double.parseDouble(tinggiBadan);
					double valueBeratBadan = Double.parseDouble(beratBadan);

					outputNama.setText(nama);
					outputUsia.setText(usia);
					outputTinggiBadan.setText(tinggiBadan);
					outputBeratBadan.setText(beratBadan);
					/*outputBeratIdeal.setText();*/
					outputStatusIdeal.setText(hitungBeratBadanIdeal(valueTinggiBadan, valueBeratBadan));
				}
			}
		});
	}

	public String hitungBeratBadanIdeal(double tinggiBadan, double beratBadan) {
		double beratIdeal = (tinggiBadan - 100) - ((tinggiBadan - 100) * 0.1);
		if (beratBadan < beratIdeal-3 || beratBadan > beratIdeal+3){
			outputStatusIdeal.setTextColor(getResources().getColor(R.color.warna_tidak_ideal));
			return "Tidak ideal";
		}else{
			outputStatusIdeal.setTextColor(getResources().getColor(R.color.border));
			return "Ideal";
		}
	}
}