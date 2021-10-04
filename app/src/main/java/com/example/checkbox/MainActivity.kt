package com.example.checkbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.checkbox.databinding.ActivityMainBinding
import com.google.android.material.slider.RangeSlider
import com.google.android.material.slider.Slider

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // Обращаемся к Рендж слайдеру через байндинг
        // addOnSliderTouchListener - это метод когда зажали Тумб и двигаем
        // в метод передаем уже тип RangeSlider
        binding?.slider?.addOnSliderTouchListener(object : RangeSlider.OnSliderTouchListener {
            // Записывает в ТекстВью текст при зажатом тумбе и активном выборе
            // в метод передаем уже тип RangeSlider
            override fun onStartTrackingTouch(slider: RangeSlider) {
                binding?.selectedPart?.text = getString(R.string.action)
            }

            // onStopTrackingTouch - который срабатывает, когда Тумб остановился
            // в метод передаем уже тип RangeSlider
            override fun onStopTrackingTouch(slider: RangeSlider) {
                // Записываем в текст вью - текст при остановке тумба
                binding?.selectedPart?.text = getString(R.string.beforeAction)
            }
        })

        // Этот метод записывает значения при передвижении слайдера и остановке на новой позиции
        // в метод передаем уже тип RangeSlider
        binding?.slider?.addOnChangeListener { rangeSlider, value, fromUser ->
            // Записываем в переменную values - значения 3 и 7 (Некое подобие массива)
            val values = rangeSlider.values
            // Содержит начальное значение
            val valueFrom = values[0].toString()
            // Содержит конечное значение
            val valueTo = values[1].toString()

            // В текст вью записываем: Стринг yourSelected + Пробел + значение слайдера + Пробел + Стринг series
            binding?.descSelectedPart?.text = getString(R.string.yourSelected) + " " + valueFrom + " " +
                    getString(R.string.to) + " " + valueTo
        }

    }
}