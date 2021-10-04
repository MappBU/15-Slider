package com.example.checkbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.checkbox.databinding.ActivityMainBinding
import com.google.android.material.slider.Slider

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // Обращаемся к слайдеру через байндинг
        // addOnSliderTouchListener - это метод когда зажали Тумб и двигаем
        binding?.slider?.addOnSliderTouchListener(object : Slider.OnSliderTouchListener {
            // Записывает в ТекстВью текст при зажатом тумбе и активном выборе
            override fun onStartTrackingTouch(slider: Slider) {
                binding?.selectedPart?.text = getString(R.string.action)
            }

            // onStopTrackingTouch - который срабатывает, когда Тумб остановился
            override fun onStopTrackingTouch(slider: Slider) {
                // Записываем в текст вью - текст при остановке тумба
                binding?.selectedPart?.text = getString(R.string.beforeAction)
            }
        })

        // Этот метод записывает значения при передвижении слайдера и остановке на новой позиции
        binding?.slider?.addOnChangeListener { slider, value, fromUser ->
            // В текст вью записываем: Стринг yourSelected + Пробел + значение слайдера + Пробел + Стринг series
            binding?.descSelectedPart?.text = getString(R.string.yourSelected) + " " + value + " " +
                    getString(R.string.series)
        }

    }
}