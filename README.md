# SBNRI
SBNRI - Next Step as Sr. Android Developer

## Objective
You have to make a project which have the following point
- Use RecyclerView to show the items.
- Use MVVM pattern for the architecture and handle screen orientation(landscape/portrait).
- Add pagination and allow the user to scroll down to load more results.
- Store the data in Realm/ Room so that users can see the existing fetched data even if the internet is not available.
- Add open_issues_count, license, permissions, name and description field for each cell in the recycler view.

Use below link for API call
```
https://api.github.com/orgs/octokit/repos?page=1&per_page=10
```
Please use the best in class libraries , design patterns to achieve above thing.

## Submission
The app can be accessed in two ways
- **Direct ( _Easy Way_ ) :**
you can directly download the apk file from the given link, and install it on you test device.

```
https://drive.google.com/file/d/1QObyuXRIMu4emeD0L4OdFhDuqQQgcD3j/view?usp=sharing
```

- **Rebuild ( _Recommended_ ) :**
Clone the git repo and open it in Android Studio. Rebuild the project and deploy it on your test device. This method ensures upto-date code deployment with the latest commits.


## Task List
Development process is divided into minor task to keep track of the process

- [x] Recyclerview to show Item
- [x] Add open_issues_count, license, permissions, name & description to RecyclerView cell
- [x] Database Implemented / Updates
- [x] Persist State
- [x] Work Offline
- [x] Paging DiffUtil Implementation
- [ ] Star Repo
- [ ] Pull to Refresh

## Architecture components 
 Architecture components help to design robust, testable and maintainable apps.

- **Data Binding :**
Declaratively bind observable data to UI elements

- **Lifecycles :**
Manage your activity and fragment lifecycles

- **LiveData :**
Notify views when underlying database changes

- **Paging :**
Gradually load information on demand from your data source

- **Room :**
Fluent SQLite database access

- **ViewModel :**
Manage UI-related data in a lifecycle-conscious way
