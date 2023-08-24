package com.example.asssessmentkotlin.Model

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.asssessmentkotlin.databinding.ActivityPostProductsBinding


class PostAdapter(var productList: List<Post>) : RecyclerView.Adapter<ProductViewHolder>() {
    lateinit var binding: ActivityPostProductsBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding =
            ActivityPostProductsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val currentItem = productList[position]
        val binding = holder.binding
        binding.tvDescription.text = currentItem.body
        binding.tvTitle.text = currentItem.title
        binding.tvId.text = currentItem.id.toString()
        binding.tvUserId.text = currentItem.userId.toString()


    }

    override fun getItemCount(): Int {
        return productList.size

    }
}

class ProductViewHolder(var binding: ActivityPostProductsBinding) :
    RecyclerView.ViewHolder(binding.root)
