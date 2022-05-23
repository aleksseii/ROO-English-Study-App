package ru.palyanaff.samsung_project_english_learning.screens.dictionary;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import ru.palyanaff.samsung_project_english_learning.data.Word;
import ru.palyanaff.samsung_project_english_learning.databinding.FragmentNewWordBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewWordFragment extends Fragment {

    private static final String TAG = "NewWordFragment";
    FragmentNewWordBinding binding;
    private String dictionaryHeader;
    public NewWordFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = FragmentNewWordBinding.inflate(getLayoutInflater());
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // header
        dictionaryHeader = NewWordFragmentArgs.fromBundle(getArguments()).getHeader();
        binding.addButton.setOnClickListener(v -> {
            String wordText = binding.textInputEditTextWord.getText().toString().trim();
            String wordTranslation = binding.textInputEditTextTranslation.getText().toString().trim();
            Word word = new Word(wordText, wordTranslation);
            // TODO: add new Word in user data
            // TODO: как-то прокинуть с прошлого фрагмента сюда header,
            //  ибо addWordInDictionary вызывается с двумя параметрами
            Log.d(TAG, wordText + " " + wordTranslation);
        });

        return binding.getRoot();
    }
}