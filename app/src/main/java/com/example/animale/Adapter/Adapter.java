package com.example.animale.Adapter;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.animale.interfaceNew.ItemClickListener;
import com.example.animale.model.Entertainment;
import com.example.animale.model.ModelAfrica;
import com.example.animale.model.ModelAmerica;
import com.example.animale.model.ModelAsia;
import com.example.animale.model.ModelAustralia;
import com.example.animale.model.ModelEuropa;
import com.example.animale.model.Type;
import com.example.animale.R;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Entertainment> animals;
    private ItemClickListener mListener;

    public void setOnItemClickListener(ItemClickListener listener) {
        mListener = listener;
    }

    public interface OnItemClickListener {
        public void onClick(View view, int position);
    }
    public Adapter(List<Entertainment> list) {
        this.animals = list;
        Log.e("Constructor", "Adapter: Succes");
    }

    @Override
    public int getItemViewType(int position) {
        //Log.e("Constructor", "getItemViewType: ");
        return animals.get(position).getType().getKey();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (viewType == Type.AnimalEuropa.getKey()) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.animal_europa, parent, false);

            AnimalEuropaViewHolder viewHolder = new AnimalEuropaViewHolder(view,mListener);

            Log.e("Adapter", "onCreateViewHolder AnimalEuropaViewHolder");

            return viewHolder;
        } else if (viewType == Type.AnimalAfrica.getKey()) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.animal_africa, parent, false);

            AnimalAfricaViewHolder viewHolder = new AnimalAfricaViewHolder(view,mListener);

            Log.e("Adapter", "onCreateViewHolder AnimalAfricaViewHolder");

            return viewHolder;
        } else if (viewType == Type.AnimalAsia.getKey()) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.animal_asia, parent, false);

            AnimalAsiaViewHolder viewHolder = new AnimalAsiaViewHolder(view,mListener);

            Log.e("Adapter", "onCreateViewHolder AnimalAsiaViewHolder");

            return viewHolder;
        } else if (viewType == Type.AnimalAmerica.getKey()) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.animal_america, parent, false);

            AnimalAmericaViewHolder viewHolder = new AnimalAmericaViewHolder(view,mListener);

            Log.e("Adapter", "onCreateViewHolder AnimalAmericaViewHolder");

            return viewHolder;
        } else if (viewType == Type.AnimalAustalia.getKey()) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.animal_australia, parent, false);

            AnimalAustraliaViewHolder viewHolder = new AnimalAustraliaViewHolder(view,mListener);

            Log.e("Adapter", "onCreateViewHolder AnimalAustraliaViewHolder");

            return viewHolder;
        }
        //Log.e("Adapter", "onCreateViewHolder: NoViewTypeFound");
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof AnimalAustraliaViewHolder) {
            ModelAustralia animalModel = (ModelAustralia) animals.get(position);

            ((AnimalAustraliaViewHolder) holder).bind(animalModel);
        } else if (holder instanceof AnimalAsiaViewHolder) {
            ModelAsia animalModel = (ModelAsia) animals.get(position);

            ((AnimalAsiaViewHolder) holder).bind(animalModel);
        } else if (holder instanceof AnimalAmericaViewHolder) {
            ModelAmerica animalModel = (ModelAmerica) animals.get(position);

            ((AnimalAmericaViewHolder) holder).bind(animalModel);
        } else if (holder instanceof AnimalEuropaViewHolder) {
            ModelEuropa animalModel = (ModelEuropa) animals.get(position);

            ((AnimalEuropaViewHolder) holder).bind(animalModel);
        } else if (holder instanceof AnimalAfricaViewHolder) {
            ModelAfrica animalModel = (ModelAfrica) animals.get(position);

            ((AnimalAfricaViewHolder) holder).bind(animalModel);
        }


        //Log.e("Adapter", "onBindViewHolder; position=" + position);
    }

    @Override
    public int getItemCount() {
        return animals.size();
    }

    public class AnimalEuropaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView nameTextView;
        private TextView continentTextView;
        private ItemClickListener listener;

        public AnimalEuropaViewHolder(@NonNull View itemView, ItemClickListener listener) {
            super(itemView);

            nameTextView = itemView.findViewById(R.id.name);
            continentTextView = itemView.findViewById(R.id.continent);
            this.listener = listener;
            itemView.setOnClickListener(this);
        }

        public void bind(ModelEuropa model) {
            nameTextView.setText(model.getName());
            continentTextView.setText(model.getContinent());
        }

        @Override
        public void onClick(View v) {
            Log.e("Animal", "Europa");
            int position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION && listener != null) {
                listener.onClick(v, position);
            }

        }
    }

    public void setClickListener(ItemClickListener itemClickListener) {
        this.mListener = itemClickListener;
    }




    class AnimalAfricaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView nameTextView;
        TextView continentTextView;
        private ItemClickListener listener;
        public AnimalAfricaViewHolder(@NonNull View itemView ,ItemClickListener listener) {
            super(itemView);

            nameTextView = itemView.findViewById(R.id.name);
            continentTextView = itemView.findViewById(R.id.continent);
            this.listener = listener;
            itemView.setOnClickListener(this);
        }

        public void bind(ModelAfrica model) {
            nameTextView.setText(model.getName());
            continentTextView.setText(model.getContinent());
        }
        @Override
        public void onClick(View v) {
            Log.e("Animal", "Africa");
            int position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION && listener != null) {
                listener.onClick(v, position);
            }
        }


    }

    class AnimalAsiaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView nameTextView;
        TextView continentTextView;
        private ItemClickListener listener;

        public AnimalAsiaViewHolder(@NonNull View itemView,ItemClickListener listener) {
            super(itemView);

            nameTextView = itemView.findViewById(R.id.name);
            continentTextView = itemView.findViewById(R.id.continent);
            this.listener = listener;
            itemView.setOnClickListener(this);
        }

        public void bind(ModelAsia model) {
            nameTextView.setText(model.getName());
            continentTextView.setText(model.getContinent());
        }
        @Override
        public void onClick(View v) {
            Log.e("Animal", "Asia");
            int position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION && listener != null) {
                listener.onClick(v, position);
            }
        }
    }

    class AnimalAmericaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView nameTextView;
        TextView continentTextView;
        private ItemClickListener listener;

        public AnimalAmericaViewHolder(@NonNull View itemView,ItemClickListener listener) {
            super(itemView);

            nameTextView = itemView.findViewById(R.id.name);
            continentTextView = itemView.findViewById(R.id.continent);
            this.listener = listener;
            itemView.setOnClickListener(this);
        }

        public void bind(ModelAmerica model) {
            nameTextView.setText(model.getName());
            continentTextView.setText(model.getContinent());
        }
        @Override
        public void onClick(View v) {
            Log.e("Animal", "America");
            int position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION && listener != null) {
                listener.onClick(v, position);
            }
        }
    }

    class AnimalAustraliaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView nameTextView;
        TextView continentTextView;
        private ItemClickListener listener;

        public AnimalAustraliaViewHolder(@NonNull View itemView,ItemClickListener listener) {
            super(itemView);

            nameTextView = itemView.findViewById(R.id.name);
            continentTextView = itemView.findViewById(R.id.continent);
            this.listener = listener;
            itemView.setOnClickListener(this);
        }

        public void bind(ModelAustralia model) {
            nameTextView.setText(model.getName());
            continentTextView.setText(model.getContinent());
        }
        @Override
        public void onClick(View v) {
            Log.e("Animal", "Australia");
            int position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION && listener != null) {
                listener.onClick(v, position);
            }
        }
    }
}
