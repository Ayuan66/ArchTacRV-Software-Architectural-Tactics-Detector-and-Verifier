import pandas as pd
from Detection.tokenizer.camel_token import camel_token
from nltk.corpus import wordnet as wn
from collections import defaultdict
from nltk.stem import WordNetLemmatizer
from nltk import pos_tag
from nltk.corpus import stopwords
from nltk.tokenize import word_tokenize
from Detection.buffer import filepath
from sklearn.preprocessing import LabelEncoder
from sklearn.tree import DecisionTreeClassifier
from sklearn.ensemble import AdaBoostClassifier
import joblib

file_path = filepath.get_authenticate_train()

corpus_data = pd.read_csv(file_path, encoding='latin-1', engine='python')
# 去除含有空缺值的行
corpus_data['text'].dropna(axis=0, how="any", inplace=True)

# 驼峰命名分割
corpus_data['text'] = [camel_token(entry) for entry in corpus_data['text']]
corpus_data
# 去除大小写
corpus_data['text'] = [str(entry).lower() for entry in corpus_data['text']]
tag_map = defaultdict(lambda: wn.NOUN)
tag_map = defaultdict(lambda: wn.NOUN)
tag_map['J'] = wn.ADJ
tag_map['V'] = wn.VERB
tag_map['R'] = wn.ADV
for index, entry in enumerate(list(corpus_data['text'])):
    final_words = []
    word_lemmatizer = WordNetLemmatizer()
    for word, tag in pos_tag(word_tokenize(entry)):
        if word not in stopwords.words('english') and word.isalpha():
            word_final = word_lemmatizer.lemmatize(word, tag_map[tag[0]])
            final_words.append(word_final)
    corpus_data.loc[index, 'text_final'] = str(final_words)

Train_X = corpus_data['text_final']
Train_Y = corpus_data['label']
Encoder = LabelEncoder()
Train_Y = Encoder.fit_transform(Train_Y)

tfidf_vector = joblib.load('TfidfVector.pkl')
Train_X_Tfidf = tfidf_vector.transform(Train_X)
AdaBoost = AdaBoostClassifier(DecisionTreeClassifier(max_depth=5), n_estimators=40)
AdaBoost.fit(Train_X_Tfidf, Train_Y)
joblib.dump(AdaBoost, 'Authenticate.pkl')
